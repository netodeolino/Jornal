package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.ILoginDAO;
import br.ufc.dao.IPapelDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class UsuarioController {

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private IUsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="loginDAO")
	private ILoginDAO lDAO;
	
	@Autowired
	@Qualifier(value="papelDAO")
	private IPapelDAO pDAO;
	
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(){
		return "usuario/inserir_usuario_formulario";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(Usuario usu,
								Papel pap,
								@RequestParam(value="imagem", required=false) MultipartFile imagem){
		
		String path = servletContext.getRealPath("/") + "resources/imagens/"+usu.getLogin() + ".png";
		AulaFileUtil.salvarImagem(path, imagem);
		
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(pap);
		usu.setPapelList(papeis);
		
		Criptografia crip = new Criptografia();
		usu.setSenha(crip.criptografar(usu.getSenha()));
		
		usu.setAtivo(true);
		
		this.uDAO.getInserirUsuario(usu);
		
		return "usuario/inserido_usuario_ok";
	}
	
	@RequestMapping("/alterarUsuarioFormulario")
	public String alterarUsuarioFormulario(Long id, Model model){
		
		Usuario usu = this.uDAO.getRecuperarUsuario(id);
		
		model.addAttribute("usuario", usu);
		return "usuario/alterar_usuario_formulario";
	}
	
	@RequestMapping("/alterarUsuario")
	public String alterarUsuario(Usuario usu){
		
		Usuario velho = this.uDAO.getRecuperarUsuario(usu.getIdUsuario());
		usu.setClassificados(velho.getClassificados());
		usu.setComentarios(velho.getComentarios());
		usu.setPapelList(velho.getPapelList());
		usu.setNoticias(velho.getNoticias());
		usu.setAtivo(true);
		
		Criptografia senha = new Criptografia();
		usu.setSenha(senha.criptografar(usu.getSenha()));
		
		this.uDAO.getAlterarUsuario(usu);
		return "../../inicio";
	}
	
	@RequestMapping("/apagarUsuario")
	public String apagarUsuario(Long id, HttpSession session){
		
		Usuario velho = uDAO.getRecuperarUsuario(id);
		velho.setAtivo(false);
		
		this.uDAO.getAlterarUsuario(velho);
		session.invalidate();
		
		return "../../inicio";
	}
	
	@RequestMapping("inserirJornalistaFormulario")
	public String formularioJornalista() {
		return "usuario/inserir_jornalista_formulario";
	}
	
	@RequestMapping("/inserirUsuarioJornalista")
	public String inserirUsuarioJornalista(Usuario usu,
										   Papel pap,
										   @RequestParam(value="imagem", required=false) MultipartFile imagem){
		
		String path = servletContext.getRealPath("/") + "resources/imagens/"+usu.getLogin() + ".png";
		AulaFileUtil.salvarImagem(path, imagem);
		
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(pap);
		
		usu.setPapelList(papeis);
		usu.setAtivo(true);
		
		Criptografia crip = new Criptografia();
		usu.setSenha(crip.criptografar(usu.getSenha()));
		
		this.uDAO.getInserirUsuario(usu);
		
		return "usuario/inserido_usuario_ok";
	}
	
	@RequestMapping("inserirEditorFormulario")
	public String formularioEditor() {
		return "usuario/inserir_editor_formulario";
	}
	
	@RequestMapping("/inserirUsuarioEditor")
	public String inserirUsuarioEditor(Usuario usu,
									   Papel pap,
									   @RequestParam(value="imagem", required=false) MultipartFile imagem){
		
		String path = servletContext.getRealPath("/") + "resources/imagens/"+usu.getLogin() + ".png";
		AulaFileUtil.salvarImagem(path, imagem);
		
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(pap);
		
		usu.setPapelList(papeis);
		usu.setAtivo(true);
		
		Criptografia crip = new Criptografia();
		usu.setSenha(crip.criptografar(usu.getSenha()));
		
		this.uDAO.getInserirUsuario(usu);
		
		return "usuario/inserido_usuario_ok";
	}
	
	@RequestMapping("/adicionarPapelFormulario")
	public String adicionarPapelFormulario(Model model){
		
		List<Papel> papeis = pDAO.getListarPapel();
		model.addAttribute("papeis", papeis);
		
		return "usuario/adicionar_papel_usuario_formulario";
	}
	
	@RequestMapping("/adicionarPapel")
	public String adicionarPapel(Usuario usuario, Papel idPapel){
		
		Usuario original = this.lDAO.getBuscarPorLogin(usuario);
		if(original == null){
			return "redirect:adicionarPapelFormulario";
		}
		
		List<Papel> papeis = original.getPapelList();
		papeis.add(idPapel);
		
		original.setPapelList(papeis);
		
		this.uDAO.getAlterarUsuario(original);
		
		return "usuario/inserido_papel_ok";
	}
	
	@RequestMapping("/configurarConta")
	public String configurarConta(){
		return "../../include/configura";
	}
	
	@RequestMapping("/acoesConta")
	public String acoesConta(){
		return "../../include/secao";
	}
}
