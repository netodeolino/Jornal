<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jornal Sistemas de Informação</title>
</head>
<body>

	<c:import url="/include/header.jsp" />
	<div class="page">

		<!-- PARA QUANDO ZERAR A BASE DE DADOS -->
		<!-- <a href="inserirEditorFormulario">EDITOR</a> -->

		<c:if test="${empty usuario}">
			<h3 align="right">Faça login seu login ou cadastre-se! :D</h3>
		</c:if>
		<c:if test="${not empty usuario}">
			<h3 align="right">${usuario.nome}:D</h3>
		</c:if>

		<div class="banner">
			<h1>Bem vindo ao Jornal SI</h1>
			<h2>Neto Deolino</h2>
		</div>

	</div>
	<c:import url="/include/footer.jsp" />

</body>
</html>