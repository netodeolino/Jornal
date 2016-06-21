<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Notícias</title>
</head>
<body>

<c:import url="/include/header.jsp" />

<div class="page">
<div class="primary-col">
<div class="generic">
	<c:forEach var="s" items="${secoes}">
		<div>
		<div class="panel">
		 <div class="title">
			<h1><b>${s.titulo}</b></h1>
			<h2>${s.descricao}</h2>
		</div>
		</div>
			<br/>
			<div>
				<c:forEach var="nots" items="${s.noticias}">
				<c:if test="${nots.ativo == true}">
				<div class="noticia_simples">
					<h1><a href="lerNoticia?idNoticia=${nots.idNoticia}"> ${nots.titulo} </a></h1>
					<h2>${nots.subtitulo}</h2> <br/>
					<img alt="Foto da Noticia" width="900" height="340" src="<c:url value="/resources/imagens/${nots.idNoticia}.png"  />" />
					<br/>
					<br/>
					
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
	</c:forEach>
</div>
</div>
</div>

<c:import url="/include/footer.jsp" />

</body>
</html>