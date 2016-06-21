<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ações do Usuário</title>
</head>
<body>

<c:import url="/include/header.jsp" />

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">

<div class="title">
	<h1 align="center">AÇÕES QUE VOCÊ PODE REALIZAR NO SISTEMA</h1>
</div>

	<c:forEach var="role" items="${usuario.papelList}">
		<c:if test="${role.papel == 'Editor'}">
			<c:if test="${teste.idPapel == 3}">
				<h3><a href="inserirJornalistaFormulario">Cadastrar Jornalista</a></h3>
				<br/>
				<h3><a href="inserirEditorFormulario">Cadastrar Editor</a></h3>
				<br/>
				<h3><a href="inserirClassificadoFormulario">Cadastrar Classificado</a></h3>
				<br/>
				<h3><a href="adicionarPapelFormulario">Adicionar Papel à um Usuário</a></h3>
				<br/>
				<h3><a href="inserirSecaoFormulario">Cadastrar Seção</a></h3> <br/> <br/>
			</c:if>
		</c:if>

		<c:if test="${role.papel == 'Jornalista'}">
			<c:if test="${teste.idPapel == 2}">
				<h3><a href="inserirNoticiaFormulario">Cadastrar Notícia</a></h3> <br/> <br/>
			</c:if>
		</c:if>
	</c:forEach>
		<br />
		<a href="inicio.jsp">Volte para a página inicial aqui!</a>
		<br />
</div>
</div>
</div>
</div>

<c:import url="/include/footer.jsp" />

</body>
</html>