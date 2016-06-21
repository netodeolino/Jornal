<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	<form action="inserirUsuarioJornalista" method="post" enctype="multipart/form-data">
		
		<div class="title">
        	<h1 align="center">CADASTRAR JORNALSTA</h1>
    	</div>
		
		Nome: <input type="text" name="nome" /> <!-- TRATAR DEPOIS <form:errors path="aluno.nome" /> -->
		<br/>
		Login: <input type="text" name="login" />
		<br/>
		Senha: <input type="password" name="senha" />
		<br/>
		Email: <input type="text" name="email" />
		<br/>
		<input type="hidden" name="idPapel" value="2">
		<br/>
		Imagem: <input type="file" name="imagem" /> <!-- SALVAR PARA SER FOTO DO PERFIL E "TRABALHO" -->
		<br/>
		
		<input type="submit" value="ENVIAR"/>
		<br/>
		<br/>
	</form>
</div>
</div>
</div>
</div>

	<c:import url="/include/footer.jsp" />

</body>
</html>