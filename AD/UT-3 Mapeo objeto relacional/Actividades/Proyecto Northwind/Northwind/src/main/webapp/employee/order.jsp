<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta name="author" content="Javier Martín Lorenzo" />
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>Order</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

	<!-- FontAwesome -->
	<link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>

	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Francois+One&family=Open+Sans:wght@300&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="../style.css">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col p-2 m-3 text-center">
				<h1>Pedido</h1>
				<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item text-dark"><a href="customer">Home</a></li>
						<li class="breadcrumb-item text-dark"><a href="customer?customerId=${customer.getCustomerID()}">Cliente</a></li>
						<li class="breadcrumb-item active text-dark">Pedido</li>
					</ol>
				</nav>
			</div>
		</div>
		<div class="row shadow-sm p-3 mb-5 bg-body rounded justify-content-center">
			<div class="col-12 text-center">
				<p class="fs-4"><span class="fw-bold">ID:</span> ${order.getOrderID()} </p>
			</div>
			<div class="col-4">
				<p><span class="fw-bold">Nombre Empleado:</span> ${order.getEmployee().getFirstName()}  ${order.getEmployee().getLastName()}</p>
			</div>
			<div class="col-4">
				<p><span class="fw-bold">Fecha:</span> ${order.getOrderDate()}</p>
			</div>
		</div>
		<div class="row shadow-sm p-3 mb-5 bg-body rounded">
			<div class="col-12">
				<h3>Productos:</h3>
			</div>
			<div class="col-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Nombre</th>
							<th scope="col">Precio</th>
							<th scope="col">Cantidad</th>
							<th scope="col">Descuento</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="total" value="${0.0}"/>
						<c:forEach items="${orderDatails}" var="detail">
							<tr>
								<th scope="row">${detail.getId()}</th>
								<td>${detail.getProduct().getProductName()}</td>
								<td>${detail.getUnitPrice()}</td>
								<td>${detail.getQuantity()}</td>
								<td>${detail.getDiscount()}</td>
								<c:set var="totalProducto" value="${detail.getUnitPrice() * detail.getQuantity()}"/>
								<c:set var="total" value="${total + totalProducto - totalProducto * detail.getDiscount()}"/>
							</tr>
						</c:forEach>
						<tr>
							<th colspan="5"></th>
						</tr>
						<tr>
							<th>TOTAL</th>
							<td colspan="4" class="text-end">${Math.round(total*100.0)/100.0}€</td>
						</tr>
					</tbody>
				</table>
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