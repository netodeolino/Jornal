<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Jornal SI</title>
<link href="resources/css/estilo_jornal.css" rel="stylesheet">
</head>
<body>

<header>
	<div class="menu-wrap">
		<nav class="menu">
			<ul>
				<li><a href="inicio.jsp">Início</a></li>
				<li><a href="verNoticia">Notícias</a></li>
				<li><a href="formularioLogin">Login</a></li>
				<c:if test="${empty usuario}">
					<li><a href="inserirUsuarioFormulario">Cadastre-se</a></li>
				</c:if>
				<c:if test="${not empty usuario}">
					<img alt="${usuario.nome}" width="85" height="85" src="<c:url value="/resources/imagens/${usuario.login}.png"  />" />
					<li><a href="configurarConta">Configurações</a></li>
					<li><a href="acoesConta">Ações</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</header>

</body>
</html>