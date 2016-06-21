<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Login</title>
</head>
<body>

	<c:import url="/include/header.jsp" />

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
<div align="center">
	<form action="fazerLogin" method="post">
		<c:if test="${usuario != null }">
			<h1>Bem vindo, ${usuario.nome}</h1>
		</c:if>
	</form>

	
	<c:if test="${usuario == null}">
	
	<div class="title">
        <h1>EFETUAR LOGIN</h1>
    </div>
		<form action="fazerLogin" method="post">

	Papel:
		<select name="idPapel" >
			<c:forEach var="pap" items = "${papeis}">
				<option value="${pap.idPapel}">${pap.papel}</option>
			</c:forEach>
		</select>
		<br/>
			Login: <input type="text" name="login"><br/>
			Senha: <input type="password" name="senha"><br/>
			<input type="submit" name="LOGAR"> <br/>
			
		</form>
	</c:if>

	<c:if test="${usuario != null}">
		<a href="inicio.jsp">Volte para a página inicial aqui!</a>
		<br/>
		<form action="sairLogin">
		<br/>
			<button type="submit">Sair</button>
		</form>
	</c:if>
</div>
</div>
</div>
</div>
</div>

	<c:import url="/include/footer.jsp" />

</body>
</html>