<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Moneda</title>
</head>
<body>
	<h1>Moneda</h1>
	<form action="">
		<input type="text" name="idmoneda" id="idmoneda" style="visibility: hidden;"/>
		<label for="nombre">Moneda: </label>
		<input type="text" name="nombre" id="nombre" value="${moneda.getNombre()}" />
		<label for="pais">País:</label>
		<input type="text" name="pais" id="pais" value="${moneda.getPais()}" />
		<input type="submit" name="submitmodificarborrar" id="submitmodificar" value="Modificar"/>
		<input type="submit" name="submitmodificarborrar" id="submitborrar" value="Borrar"/>
	</form>
</body>
</html>