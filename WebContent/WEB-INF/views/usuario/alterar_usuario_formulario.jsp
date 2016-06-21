<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Alterar Usuário</title>
</head>
<body>

	<c:import url="/include/header.jsp"/>

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
<form action="alterarUsuario" method="post">
	<br/>
	<input type="hidden" name="idUsuario" value="${usuario.idUsuario}" />
	<input type="hidden" name="login" value="${usuario.login}" />
	Nome: <input type="text" name="nome" value="${usuario.nome}" />    <br />
	Email: <input type="text" name="email" value="${usuario.email}" />	 <br />
	Senha: <input type="password" name="senha" value="${usuario.senha}" />   <br />
	<input type="submit" value="ALTERAR" />
	<br/>
</form>
</div>
</div>
</div>
</div>

	<c:import url="/include/footer.jsp" />

</body>
</html>