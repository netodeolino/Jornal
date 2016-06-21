<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Alterar Notícia</title>
</head>
<body>

	<c:import url="/include/header.jsp"/>

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
<form action="alterarNoticia" method="post" enctype="multipart/form-data">

	<div class="title">
       	<h1 align="center">ALTERAR NOTÍCIA</h1>
    </div>

	<input type="hidden" name="idNoticia" value="${noticia.idNoticia}" />
	<input  type="hidden" name="idAutor" value="${noticia.idAutor}">
	<input  type="hidden" name="idSecao" value="${noticia.idSecao}">
	Titulo: <input type="text" name="titulo" value="${noticia.titulo}" /><br />
	Sub-Titulo: <input type="text" name="subtitulo" value="${noticia.subtitulo}" /><br />
	Texto: <textarea rows="10" cols="45" name="texto">${noticia.texto}"</textarea> <br /> <br />
	
	<input type="submit" value="ALTERAR" />
</form>
</div>
</div>
</div>
</div>

	<c:import url="/include/footer.jsp" />

</body>
</html>