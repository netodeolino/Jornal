<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Configurações de Conta</title>
</head>
<body>

<c:import url="/include/header.jsp" />

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
	<div>
	<div class="title">
		<h1 align="center">Atualizar informações de conta</h1>
	</div>
		<h3><a href="alterarUsuarioFormulario?id=${usuario.idUsuario}">Atualize suas informações</a></h3>
		<br />
		<h3><a href="apagarUsuario?id=${usuario.idUsuario}">Apagar Conta</a></h3>
		<br />
		<br />
		<a href="inicio.jsp">Volte para a página inicial aqui!</a>
		<br />
	</div>
</div>
</div>
</div>
</div>

<c:import url="/include/footer.jsp" />

</body>
</html>