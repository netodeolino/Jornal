<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Alterar Comentário</title>
</head>
<body>

	<c:import url="/include/header.jsp" />

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
	<form action="alterarComentario" method="post">
	
	<div class="title">
       	<h1>ALTERAR COMENTÁRIO</h1>
    </div>
	
	<input type="hidden" name="idComentario" value="${comentario.idComentario}" />
	<input type="hidden" name="idAutor" value="${comentario.idAutor}" />
	<input type="hidden" name="idNoticia" value="${comentario.idNoticia}" />
	Texto: <textarea rows="10" cols="45" name="texto">${comentario.texto}"</textarea> <br />
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