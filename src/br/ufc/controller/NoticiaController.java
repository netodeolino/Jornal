package br.ufc.controller;

import java.util.Date;
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

import br.ufc.dao.IClassificadoDAO;
import br.ufc.dao.IComentarioDAO;
import br.ufc.dao.INoticiaDAO;
import br.ufc.dao.ISecaoDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.util.AulaFileUtil;

@Transactional
@Controller
public class NoticiaController {
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	@Qualifier(value="noticiaDAO")
	private INoticiaDAO nDAO;
	
	@Autowired
	@Qualifier(value="secaoDAO")
	private ISecaoDAO sDAO;
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private IUsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="comentarioDAO")
	private IComentarioDAO cDAO;
	
	@Autowired
	@Qualifier(value="classificadoDAO")
	private IClassificadoDAO claDAO;
	
	@RequestMapping("/inserirNoticiaFormulario")
	public String inserirNoticiaFormulario(Model model){
		List<Secao> secoes = sDAO.getListarSecao();
		model.addAttribute("secoes", secoes);
		
		return "noticia/inserir_noticia_formulario";
	}
	
	@RequestMapping("/inserirNoticia")
	public String inserirNoticia(Noticia not,
								HttpSession session,
								@RequestParam(value="imagem", required=false) MultipartFile imagem){
		Date dat = new Date(System.currentTimeMillis());
		not.setDataNoticia(dat);
		
		
		
		not.setSecao(sDAO.getRecuperarSecao(not.getIdSecao()));
		not.setAtivo(true);
		
		this.nDAO.getInserirNoticia(not);
		
		Noticia n = this.nDAO.getRecuperarNoticia(not.getTitulo());
		
		String path = servletContext.getRealPath("/") + "resources/imagens/"+ n.getIdNoticia() + ".png";
		AulaFileUtil.salvarImagem(path, imagem);
		
		return "noticia/inserido_noticia_ok";
	}
	
	@RequestMapping("/alterarNoticiaFormulario")
	public String alterarNoticiaFormulario(Long idNoticia, Model model){
		
		Noticia not = this.nDAO.getRecuperarNoticia(idNoticia);
		
		model.addAttribute("noticia", not);
		return "noticia/alterar_noticia_formulario";
	}
	
	@RequestMapping("/alterarNoticia")
	public String alterarNoticia(Noticia not, @RequestParam(value="imagem", required=false) MultipartFile imagem){
		Date dat = new Date(System.currentTimeMillis());
		not.setDataNoticia(dat);
		
		not.setAtivo(true);
		
		this.nDAO.getAlterarNoticia(not);
		return "redirect:verNoticia";
	}
	
	@RequestMapping("/verNoticia")
	public String verNoticia(Model model) {
		
		List<Secao> secoes = this.sDAO.getListarSecao();
		model.addAttribute("secoes", secoes);

		return "noticia/noticia_simples";

	}
	
	@RequestMapping("/lerNoticia")
	public String lerNoticia(Noticia not, Model model){
		
		Noticia aqui = this.nDAO.getRecuperarNoticia(not.getIdNoticia());
		List<Comentario> coms = aqui.getComentarios();
		List<Classificado> clas = this.claDAO.getListarClassificado();
		
		model.addAttribute("noticia", aqui);
		model.addAttribute("comentaris", coms);
		model.addAttribute("classificados", clas);
		
		return "noticia/noticia_detalhada";
	}
	
	@RequestMapping("/apagarNoticia")
	public String apagarNoticia(Noticia not){
		Noticia notVelha = this.nDAO.getRecuperarNoticia(not.getIdNoticia());
		
		notVelha.setAtivo(false);
		
		this.nDAO.getAlterarNoticia(notVelha);
		
		return "redirect:verNoticia";
	}
}
