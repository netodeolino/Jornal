<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Inicío</title>
</head>
<body>

	<c:import url="/include/header.jsp"/>

	<h2>Menu</h2>
	
	<h3>Usuário</h3>
	<a href="inserirUsuarioFormulario">Inserir Usuário</a> <br/>
	<a href="listarUsuario">Listar Usuários</a> <br/>
	
	<h3>Classificado</h3>
	<a href="inserirClassificadoFormulario">Inserir Classificado</a> <br/>
	<a href="listarClassificado">Listar Classificado</a> <br/>
	
	<h3>Comentário</h3>
	<a href="inserirComentarioFormulario">Inserir Comentário</a> <br/>
	<a href="listarComentario">Listar Comentário</a> <br/>
	
	<h3>Noticia</h3>
	<a href="inserirNoticiaFormulario">Inserir Noticia</a> <br/>
	<a href="listarNoticia">Listar Noticia</a> <br/>
	
	<h3>Seção</h3>
	<a href="inserirSecaoFormulario">Inserir Seção</a> <br/>
	<a href="listarSecao">Listar Seção</a> <br/>
	
	<h3>JORNALISTA</h3>
	<a href="inserirJornalistaFormulario">JORNALISTA</a> <br/>

	<h3>EDITOR</h3>
	<a href="inserirEditorFormulario">EDITOR</a> <br/>

	<h3>Login</h3>
	<a href="formularioLogin">Realizar Login</a> <br/>

<footer> 
		<c:import url="/include/footer.jsp" />
</footer>

</body>
</html>