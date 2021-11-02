<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tarea de Clase</title>
    </head>
    <body>
        <h3>Poner el nombre del fichero y el texto que quieras guardar:</h3>
        <h4>(si no existe el fichero se crea nuevo. Si existe se sobreescribe)</h4>
        
        <form action="Principal" method="POST"> 
			<label for="nick">Nombre fichero: </label>
			<input type="text" name="nombre" id="nombre"  value="${nombreFichero}"/>
			<br/><br/>
			<textarea rows="10" cols="100" name="texto" id="texto">${texto}</textarea>
			<br/><br/>
			<input type="submit" value="Enviar"/>
		</form>
		
		<c:choose>
			<c:when test="${guardado == true}">
				<p>el fichero: ${nombreFichero} se ha guardado</p>
			</c:when>
			<c:when test="${guardado == false}">
				<p>existen problemas con el fichero: ${nombreFichero}</p>
			</c:when>
			<c:otherwise>
				<br/>
			</c:otherwise>
		</c:choose>
		
		<hr/><hr/>
		
		<h3>Puedes cargar un fichero para editarlo escribiendo el nombre aquí</h3>
        <h4>(si no existe el fichero se crea nuevo)</h4>
        
        <form action="Principal" method="POST"> 
			<label for="nick">Nombre fichero: </label>
			<input type="text" name="nombreCargar" id="nombreCargar"/>
			<input type="submit" value="Cargar"/>
		</form>
    </body>
</html>
