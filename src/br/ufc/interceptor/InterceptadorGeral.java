package br.ufc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Component
public class InterceptadorGeral extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String URI = request.getRequestURI();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Papel papel = null;
		
		if(URI.equals("/jornal/resources/css/estilo_jornal.css") || URI.contains("resources/imagens/")){
			return true;
		}
		
		if(request.getSession().getAttribute("teste") != null){
			papel = (Papel) request.getSession().getAttribute("teste");
		}
		
		if(URI.endsWith("formularioLogin") || URI.endsWith("verNoticia") ||
				URI.endsWith("lerNoticia") || URI.endsWith("inserirUsuarioFormulario") || URI.endsWith("inicio.jsp") ||
				URI.endsWith("fazerLogin") || URI.endsWith("sairLogin") || URI.endsWith("inserirUsuario")){
			return true;
		}
		
		if(usuario != null){
			if(URI.endsWith("formularioLogin") || URI.endsWith("inicio.jsp") || URI.endsWith("verNoticia") || URI.endsWith("lerNoticia")
					|| URI.endsWith("inserirUsuarioFormulario") || URI.endsWith("inicio.jsp") || URI.endsWith("acoesConta")
					|| URI.endsWith("configurarConta") || URI.endsWith("alterarUsuarioFormulario") || URI.endsWith("apagarUsuario")
					|| URI.endsWith("alterarUsuario")){
				return true;
			}
			
			if(papel.getIdPapel() == 1){
				if(URI.endsWith("inserirComentario") || URI.endsWith("alterarComentarioFormulario")
						 || URI.endsWith("alterarComentario") || URI.endsWith("apagarComentario")
						 || URI.endsWith("alterarClassificado")){
					return true;
				}
			}else if(papel.getIdPapel() == 2){
				if(URI.endsWith("apagarNoticia") || URI.endsWith("inserirNoticia")
						|| URI.endsWith("alterarNoticia") || URI.endsWith("inserirNoticiaFormulario")
						|| URI.endsWith("alterarNoticiaFormulario")){
					return true;
				}
			}else{
				if(URI.endsWith("apagarNoticia") || URI.endsWith("inserirClassificado")
						|| URI.endsWith("inserirSecaoFormulario") || URI.endsWith("inserirJornalistaFormulario")
						|| URI.endsWith("inserirUsuarioJornalista") || URI.endsWith("inserirClassificadoFormulario")
						|| URI.endsWith("adicionarPapelFormulario") || URI.endsWith("adicionarPapel")
						|| URI.endsWith("inserirSecao") || URI.endsWith("inserirSecaoFormulario")
						|| URI.endsWith("inserirEditorFormulario") || URI.endsWith("inserirUsuarioEditor")){
					return true;
				}
			}
			response.sendRedirect("inicio.jsp");
			return false;
		}
		
		response.sendRedirect("inicio.jsp");
		return false;
	}
}
