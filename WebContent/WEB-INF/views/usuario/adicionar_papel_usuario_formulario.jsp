<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar Papel</title>
</head>
<body>

	<c:import url="/include/header.jsp" />

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
	<form action="adicionarPapel" method="post">
	
	<div class="title">
       	<h1>CADASTRAR PAPEL À USUÁRIO</h1>
    </div>
	
	Papel:
		<select name="idPapel" >
			<c:forEach var="pap" items = "${papeis}">
				<option value="${pap.idPapel}">${pap.papel}</option>
			</c:forEach>
		</select>
		<br/>
	
		<br/>
		Login: <input type="text" name="login" />
		<br/>
		Senha: <input type="password" name="senha" />
		<br/>
		<input type="submit" value="ENVIAR"/>
		<br/>
	</form>
</div>
</div>
</div>
</div>

	<c:import url="/include/footer.jsp" />

</body>
</html>