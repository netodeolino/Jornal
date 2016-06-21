<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Alterar Seção</title>
</head>
<body>

	<c:import url="/include/header.jsp"/>

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
	<form action="alterarSecao" method="post">
	
	<div class="title">
       	<h1 align="center">ALTERAR SEÇÃO</h1>
    </div>
	
	<input type="hidden" name="idSecao" value="${secao.idSecao}" />
	Titulo: <input type="text" name="titulo" value="${secao.titulo}" /><br />
	Descrição: <input type="text" name="descricao" value="${secao.descricao}" /><br />
	<input type="submit" value="ALTERAR" />
	</form>
</div>
</div>
</div>
</div>

	<c:import url="/include/footer.jsp" />

</body>
</html>