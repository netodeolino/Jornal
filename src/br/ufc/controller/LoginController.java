package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ILoginDAO;
import br.ufc.dao.IPapelDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class LoginController {

	@Autowired
	@Qualifier(value="loginDAO")
	private ILoginDAO lDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private IPapelDAO pDAO;
	
	@RequestMapping("/formularioLogin")
	public String formularioLogin(Model model){
		
		List<Papel> paps = pDAO.getListarPapel();
		model.addAttribute("papeis", paps);
		
		return "login/login";
	}
	
	@RequestMapping("/fazerLogin")
	public String fazerLogin(Usuario usu, HttpSession session, Long idPapel){
		
		if((usu.getSenha() == null) || (usu.getLogin() == null)){
			return "redirect:formularioLogin";
		}
		
		Criptografia crip = new Criptografia();
		usu.setSenha(crip.criptografar(usu.getSenha()));
		
		Usuario u = lDAO.getBuscarPorLogin(usu);
		if(u == null){
			return "redirect:formularioLogin";
		}
		
		Papel log = new Papel();
		log.setIdPapel(idPapel);
		
		List<Papel> papeis = u.getPapelList();
		for(Papel pap : papeis){
			if(pap.getIdPapel() == idPapel){
				if(u.getSenha().equals(usu.getSenha()) && u.getLogin().equals(usu.getLogin()) && u.isAtivo() != false){
					if(idPapel == 1){
						session.setAttribute("teste", log);
						session.setAttribute("usuario", u);
						
						return "redirect:formularioLogin";
					}
					if(idPapel == 2){
						session.setAttribute("teste", log);
						session.setAttribute("usuario", u);
						
						return "redirect:formularioLogin";
					}
					if(idPapel == 3){
						session.setAttribute("teste", log);
						session.setAttribute("usuario", u);
						
						return "redirect:formularioLogin";
					}
				}
			}
		}
		
		return "redirect:formularioLogin";
	}
	
	@RequestMapping("/sairLogin")
	public String sairLogin(HttpSession session){
		session.invalidate();
		
		return "../../inicio";
	}
}
