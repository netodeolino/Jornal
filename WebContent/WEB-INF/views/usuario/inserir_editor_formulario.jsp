<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Cadastro</title>
</head>
<body>

	<c:import url="/include/header.jsp" />

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
	<form action="inserirUsuarioEditor" method="post" enctype="multipart/form-data">
		
		<div class="title">
        	<h1>CADASTRAR EDITOR</h1>
    	</div>
		
		Nome: <input type="text" name="nome" />
		<br/>
		Login: <input type="text" name="login" />
		<br/>
		Senha: <input type="password" name="senha" />
		<br/>
		Email: <input type="text" name="email" />
		<br/>
		<input type="hidden" name="idPapel" value="3">
		<br/>
		Imagem: <input type="file" name="imagem" />
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