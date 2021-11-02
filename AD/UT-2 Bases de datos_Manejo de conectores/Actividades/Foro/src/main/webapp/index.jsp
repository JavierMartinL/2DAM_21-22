<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta name="author" content="Javier Martín">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="refresh" content="20">
		
		<title>Foro web</title>
		
		<link rel="stylesheet" href="css/estilos.css">
	</head>
	
	<body>
		<h1 class="cabecera">IRC Foro</h1>
		<div class="principal">
			<div class="foro">
				<c:forEach var="mens" items="${mensajes}">
					<c:out value="${mens}"></c:out>
					<br>
				</c:forEach>
			</div>
			
			<ul class="conectados">
				<c:forEach var="usuarios" items="${usuariosConectados}">
						<c:out value="${usuarios}"></c:out>
						<br>
					</c:forEach>
			</ul>
			
			<form method="POST"> 
				<label for="nombre">nombre: </label>
				<input type="text" name="nombre" id="nombre" value="${nombreUsuario}" ${nombreUsuario != null ? 'readonly' : ''}>
				<textarea name="mensaje" id="mensaje" cols="20" rows="10"></textarea>
				<input type="submit" value="Enviar">
			</form>
		</div>
	</body>
</html>