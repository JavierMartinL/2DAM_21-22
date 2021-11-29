<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Estas dentro de monedas</h1>
 
 <a href="../logout">Cerrar Session</a>
 
 <ul>
 	<c:forEach items="${listadomonedas}" var="moneda">
 		<li>
 			<a href="monedas?idmoneda=${moneda.getIdmoneda()}">
 				${moneda.getNombre()} ${moneda.getPais()}
 			</a>
 		</li>
 	</c:forEach>
 </ul>
 
</body>
</html>