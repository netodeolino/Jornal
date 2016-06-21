package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ISecaoDAO;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {

	@Autowired
	@Qualifier(value="secaoDAO")
	private ISecaoDAO sDAO;
	
	@RequestMapping("/inserirSecaoFormulario")
	public String inserirSecaoFormulario(){
		return "secao/inserir_secao_formulario";
	}
	
	@RequestMapping("/inserirSecao")
	public String inserirSecao(Secao sec){
		
		this.sDAO.getInserirSecao(sec);
		
		return "secao/inserido_secao_ok";
	}
	
	@RequestMapping("/alterarSecaoFormulario")
	public String alterarSecaoFormulario(Long id, Model model){
		
		Secao sec = this.sDAO.getRecuperarSecao(id);
		
		model.addAttribute("secao", sec);
		return "secao/alterar_secao_formulario";
	}
	
	@RequestMapping("/alterarSecao")
	public String alterarSecao(Secao sec){
		this.sDAO.getAlterarSecao(sec);
		return "redirect:listarSecao";
	}
	
	@RequestMapping("/apagarSecao")
	public String apagarSecao(Long id){
		this.sDAO.getRemoverSecao(id);
		return "redirect:listarSecao";
	}
}
