<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Inserir Secao</title>
</head>
<body>

	<c:import url="/include/header.jsp"/>

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
	<form action="inserirSecao" method="POST">
		
		<div class="title">
        	<h1>CADASTRAR SEÇÃO</h1>
    	</div>
		
		Titulo: <input type="text" name="titulo" />
		<br/>
		Descrição: <input type="text" name="descricao" />
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