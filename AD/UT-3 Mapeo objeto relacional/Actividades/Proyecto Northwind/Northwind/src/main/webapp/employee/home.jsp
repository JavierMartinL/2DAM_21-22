<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta name="author" content="Javier Martín Lorenzo" />
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>Home</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous">
		
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Francois+One&family=Open+Sans:wght@300&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" href="../style.css">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-12 p-2 m-3 text-center">
				<h1>Clientes</h1>
				<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item active text-dark">Home</li>
					</ol>
				</nav>
			</div>
		</div>
		<div class="row m-2">
			<div class="col-12 col-lg-8 offset-lg-2">
				<div class="list-group">
					<c:forEach items="${listaClientes}" var="cliente">
						<a href="customer?customerId=${cliente.getCustomerID()}" class="list-group-item list-group-item-action">${cliente.getCustomerID()} - ${cliente.getContactName()}</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>