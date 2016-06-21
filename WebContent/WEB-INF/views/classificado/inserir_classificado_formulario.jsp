<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Inserir Classificado</title>
</head>
<body>

	<c:import url="/include/header.jsp" />

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
	<form action="inserirClassificado" method="post">
		
		<div class="title">
        	<h1>CADASTRAR CLASSIFICADO</h1>
    	</div>
		
		Titulo: <input type="text" name="titulo" /> <br />
		Texto: <textarea rows="10" cols="45" name="texto"></textarea> <br /> 
		<!-- <input type="text" name="texto" /> <br /> -->
		Preço: <input type="text" name="preco" /> <br />
		Telefone: <input type="text" name="telefone" /> <br />
		<input type="hidden" name="idAutor" value="${usuario.idUsuario}"> <br />
		<input type="submit" value="ENVIAR" />
		<br/>
	</form>
</div>
</div>
</div>
</div>

	<c:import url="/include/footer.jsp" />

</body>
</html>