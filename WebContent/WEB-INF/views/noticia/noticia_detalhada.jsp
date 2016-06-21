<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Notícia</title>
</head>
<body>

	<c:import url="/include/header.jsp" />

<div class="page">
<div class="primary-col">
<div class="generic">
<div class="panel">
	<div>
		<h3 align="left"> ${noticia.secao.titulo} <br /> ${noticia.dataNoticia}</h3>
		<div class="title">
			<h1><b>${noticia.titulo}</b></h1>
		</div>
		
		<img alt="Foto da Noticia" width="900" height="350" src="<c:url value="/resources/imagens/${noticia.idNoticia}.png"  />" />
		<br/> <br/>
			<h2>${noticia.subtitulo}</h2>
			<br/>
			<div class="texto"><p>${noticia.texto}</p></div>
		<br/>
		<div align="right">
			<b>Autor da Noticia:</b> ${noticia.autor.nome}
		</div>
		<img alt="Foto do Autor" width="50" height="50" align="right"
			src="<c:url value="/resources/imagens/${noticia.autor.login}.png"  />" />
	</div>

	<c:forEach var="role" items="${usuario.papelList}">

		<c:if test="${role.papel=='Editor'}">
		<c:if test="${teste.idPapel == 3}">
			<h3><a href="apagarNoticia?idNoticia=${noticia.idNoticia}">Excluir Notícia</a></h3>
		</c:if>
		</c:if>

		<c:if test="${role.papel=='Jornalista'}">
		<c:if test="${teste.idPapel == 2}">
			<h3><a href="apagarNoticia?idNoticia=${noticia.idNoticia}">Excluir Notícia</a></h3> <br/>
			<h3><a href="alterarNoticiaFormulario?idNoticia=${noticia.idNoticia}">Alterar Notícia</a></h3>
		</c:if>
		</c:if>

		<c:if test="${role.papel=='Leitor'}">
		<c:if test="${teste.idPapel == 1}">
		<br/>
		<h2>Comente</h2>
			<form action="inserirComentario" method="post">
				<div>
					<textarea name="texto" id="texto" cols="45"></textarea>
				</div>
				<input type="hidden" name="idAutor" value="${usuario.idUsuario}">
				<input type="hidden" name="idNoticia" value="${noticia.idNoticia}">
				<input type="submit" name="Comentar">
			</form>
		</c:if>
		</c:if>
	</c:forEach>
	
	<br/>
	
	<h2>Comentários</h2>
	<br/>
	<div>
		<c:forEach var="comentario" items="${comentaris}">
			
			<c:if test="${comentario.ativo == true}">
			<div>
				<div>
					<h4><b>Autor do Comentário:</b> ${comentario.autor.nome}</h4>
				</div>
				<div style="font-size: 17px;" class="texto">${comentario.texto}</div> <br/>
			</div>
			<c:if test="${comentario.idAutor == usuario.idUsuario}">
				<div class="button"><a href="apagarComentario?idComentario=${comentario.idComentario}">Excluir</a></div>
				<div class="button"><a href="alterarComentarioFormulario?id=${comentario.idComentario}">Editar</a></div>
				 <br/> <br/>
			</c:if>
			</c:if>
		</c:forEach>
	</div>

	<div>
	<br/>
	<h2>Classificados</h2>
		<c:forEach var="classificado" items="${classificados}">
			<div>
				<div>
					<h4><b>Titulo:</b> ${classificado.titulo}</h4>
				</div>
				<div><b>Descrição:</b> ${classificado.texto}</div>
				<div><b>Preço Inicial:</b> ${classificado.preco}</div>
				<div><b>Melhor Oferta:</b> ${classificado.melhorOferta}</div>
				<div><b>Telefone:</b> ${classificado.telefone}</div>
				<c:forEach var="role" items="${usuario.papelList}">
					<c:if test="${role.papel=='Leitor'}">
						<c:if test="${teste.idPapel == 1}">
							<form action="alterarClassificado">
								<input type="hidden" name="idClassificado" value="${classificado.idClassificado}">
								<input type="hidden" name="titulo" value="${classificado.titulo}">
								<input type="hidden" name="texto" value="${classificado.texto}">
								<input type="hidden" name="preco" value="${classificado.preco}">
								<input type="hidden" name="telefone" value="${classificado.telefone}">
								<input type="hidden" name="idAutor" value="${classificado.idAutor}">
								<input type="hidden" name="idNoticia" value="${noticia.idNoticia}">
								<b>Nova oferta:</b> <input type="text" name="melhorOferta" value="${classificado.melhorOferta}" />
								
								<input type="submit" name="Ofertar">
							</form>
						</c:if>
					</c:if>
					
					<c:if test="${role.papel=='Editor'}">
						<c:if test="${teste.idPapel == 3}">
							<h3><a href="apagarClassificado?id=${classificado.idClassificado}">Excluir Classificado</a></h3> <br/>
						</c:if>
					</c:if>
				</c:forEach>
			</div>
		</c:forEach>
		<br/>
	</div>
</div>
</div>
</div>
</div>
	<c:import url="/include/footer.jsp" />

</body>
</html>