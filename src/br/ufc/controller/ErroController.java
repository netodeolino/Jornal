package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErroController {

	@RequestMapping("/Erro")
	public String Error(){
		return "erro/erro";
	}
}
