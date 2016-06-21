<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Inserir Notícia</title>
</head>
<body>

	<c:import url="/include/header.jsp"/>

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
	<form action="inserirNoticia" method="POST" enctype="multipart/form-data">
		
		<div class="title">
        	<h1 align="center">CADASTRAR NOTÍCIA</h1>
    	</div>
		
		<select name="idSecao" >
			<c:forEach var="sec" items = "${secoes}">
				<option value="${sec.idSecao}">${sec.titulo}</option>
			</c:forEach>
		</select>
		
		<br/>
		Titulo: <input type="text" name="titulo" />
		<br/>
		Sub-Titulo: <input type="text" name="subtitulo" />
		<br/>
		Texto: <textarea rows="10" cols="45" name="texto"></textarea>
		<br/>
		<input  type="hidden" name="idAutor" value="${usuario.idUsuario}">
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