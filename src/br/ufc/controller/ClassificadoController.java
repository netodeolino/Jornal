package br.ufc.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IClassificadoDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Noticia;

@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	@Qualifier(value="classificadoDAO")
	private IClassificadoDAO cDAO;
	
	@RequestMapping("/inserirClassificadoFormulario")
	public String inserirClassificadoFormulario(){
		return "classificado/inserir_classificado_formulario";
	}
	
	@RequestMapping("/inserirClassificado")
	public String inserirClassificado(HttpSession session, Classificado cla){
		
		Date dat = new Date(System.currentTimeMillis());
		cla.setDataOferta(dat);
		
		this.cDAO.getInserirClassificado(cla);
		
		return "classificado/inserido_classificado_ok";
	}
	
	@RequestMapping("/alterarClassificado")
	public String alterarClassificado(Classificado cla, Noticia not){
		
		Classificado velho = cDAO.getRecuperarClassificado(cla.getIdClassificado());
		
		System.out.println(velho.getTexto());
		
		if(velho.getPreco() > cla.getMelhorOferta()){
			return "redirect:verNoticia";
		}
		
		if(velho.getMelhorOferta() != null && velho.getMelhorOferta() > cla.getMelhorOferta()){
			return "redirect:verNoticia";
		}
		
		cla.setDataOferta(velho.getDataOferta());
		
		this.cDAO.getAlterarClassificado(cla);
		return "redirect:lerNoticia?idNoticia="+not.getIdNoticia();
	}
	
	@RequestMapping("/apagarClassificado")
	public String apagarClassificado(Long id){
		this.cDAO.getRemoverClassificado(id);
		return "redirect:verNoticia";
	}
}
