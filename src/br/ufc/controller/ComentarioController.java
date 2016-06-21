package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IComentarioDAO;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;

@Transactional
@Controller
public class ComentarioController {

	@Autowired
	@Qualifier(value="comentarioDAO")
	private IComentarioDAO cDAO;
	
	@RequestMapping("/inserirComentario")
	public String inserirComentario(HttpSession session, Comentario com, Noticia not, Model model){
		
		com.setIdNoticia(not.getIdNoticia());
		com.setAtivo(true);
		
		this.cDAO.getInserirComentario(com);
		
		return "redirect:lerNoticia?idNoticia="+not.getIdNoticia();
	}
	
	@RequestMapping("/alterarComentarioFormulario")
	public String alterarComentarioFormulario(Long id, Model model){
		
		Comentario com = this.cDAO.getRecuperarComentario(id);
		
		model.addAttribute("comentario", com);
		return "comentario/alterar_comentario_formulario";
	}
	
	@RequestMapping("/alterarComentario")
	public String alterarComentario(Comentario com){
		com.setAtivo(true);
		
		this.cDAO.getAlterarComentario(com);
		return "redirect:verNoticia";
	}
	
	@RequestMapping("/apagarComentario")
	public String apagarComentario(Comentario com){
		
		Comentario velho = cDAO.getRecuperarComentario(com.getIdComentario());
		velho.setAtivo(false);
		
		this.cDAO.getAlterarComentario(velho);
		return "redirect:lerNoticia?idNoticia="+velho.getIdNoticia();
	}
}
