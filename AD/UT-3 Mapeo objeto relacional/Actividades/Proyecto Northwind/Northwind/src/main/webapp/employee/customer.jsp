<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta name="author" content="Javier Martín Lorenzo" />
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Customer</title>

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
				<h1>Cliente</h1>
				<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item text-dark"><a href="customer">Home</a></li>
						<li class="breadcrumb-item active text-dark">Cliente</li>
					</ol>
				</nav>
			</div>
		</div>
		<div class="row shadow-sm p-3 mb-5 bg-body rounded justify-content-center">
			<div class="col-12 text-center">
				<p class="fs-4"><span class="fw-bold">ID:</span> ${customer.getCustomerID()} </p>
			</div>
			<div class="col-4">
				<p><span class="fw-bold">Nombre Compañia:</span> ${customer.getCompanyName()}</p>
			</div>
			<div class="col-4">
				<p><span class="fw-bold">Contacto:</span> ${customer.getContactName()}</p>
			</div>
			<div class="col-3">
				<p><span class="fw-bold">Titulo Contacto:</span> ${customer.getContactTitle()}</p>
			</div>
			<div class="col-3">
				<p><span class="fw-bold">Dirección:</span> ${customer.getAddress()}</p>
			</div>
			<div class="col-2">
				<p><span class="fw-bold">Ciudad:</span> ${customer.getCity()}</p>
			</div>
			<div class="col-2">
				<p><span class="fw-bold">País:</span> ${customer.getCountry()}</p>
			</div>
			<div class="col-2">
				<p><span class="fw-bold">Código:</span> ${customer.getPostalCode()}</p>
			</div>
			<div class="col-3">
				<p><span class="fw-bold">Región:</span> ${customer.getRegion()}</p>
			</div>
			<div class="col-3">
				<p><span class="fw-bold">Fax:</span> ${customer.getFax()}</p>
			</div>
			<div class="col-3">
				<p><span class="fw-bold">Teléfono:</span> ${customer.getPhone()}</p>
			</div>
		</div>
		<div class="row shadow-sm p-3 mb-5 bg-body rounded">
			<div class="col-6">
				<h3>Pedidos:</h3>
			</div>
			<div class="col-6 text-end">
				<a href="order?newOrder=${customer.getCustomerID()}" class="btn btn-secondary">Crear nuevo Pedido</a>
			</div>
			<div class="col-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Fecha</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ordersCustomer}" var="order">
							<tr>
								<th scope="row">${order.getOrderID()}</th>
								<td>${order.getOrderDate()}</td>
								<td class="text-center"><a href="order?orderId=${order.getOrderID()}" class="link-primary"><i class="fas fa-info"></i></a></td>
								<td class="text-center"><a href="#" class="link-warning"><i class="fas fa-edit"></i></a></td>
								<td class="text-center"><a href="#" class="link-danger"><i class="fas fa-trash-alt"></i></a></td>
							</tr>
						</c:forEach>
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