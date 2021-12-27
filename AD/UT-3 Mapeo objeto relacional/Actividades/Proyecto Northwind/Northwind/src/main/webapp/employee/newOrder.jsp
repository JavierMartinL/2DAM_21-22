<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="author" content="Javier Martín Lorenzo" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nuevo Pedido</title>

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
            <div class="col-12 text-center">
                <h1>Nuevo Pedido</h1>
                <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item text-dark"><a href="customer">Home</a></li>
						<li class="breadcrumb-item text-dark"><a href="customer?customerId=${customer.getCustomerID()}">Cliente</a></li>
						<li class="breadcrumb-item active text-dark">Nuevo Pedido</li>
					</ol>
				</nav>
            </div>
        </div>
        <div class="row shadow-sm p-3 mb-5 bg-body rounded">
            <div class="col-12">
                <h3>Carrito:</h3>
            </div>
            <c:if test="${newOrderDetails != null }">
                <div class="col-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Precio</th>
                                <th scope="col">Cantidad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="total" value="${0.0}"/>
                            <c:forEach items="${newOrderDetails}" var="detail">
                                <tr>
                                    <th scope="row">${detail.getProduct().getProductName()}</th>
                                    <td>${detail.getUnitPrice()}</td>
                                    <td>${detail.getQuantity()}</td>
                                    <c:set var="totalProducto" value="${detail.getUnitPrice() * detail.getQuantity()}"/>
                                    <c:set var="total" value="${total + totalProducto}"/>
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
            
                <div class="col-12 text-end">
                    <form action="order" method="post">
                        <input type="submit" class="btn btn-secondary" name="submit" value="Realizar Pedido">
                    </form>
                </div>
            </c:if>
        </div>
        <div class="row shadow-sm p-3 mb-5 bg-body rounded">
            <c:forEach items="${listaProductos}" var="producto">
                <div class="col-6 mt-2 mb-2">
                    <div class="row">
                        <div class="col-5">				
                            ${producto.getProductName()}
                        </div>
                        <div class="col-7">
                            <form action="order" method="POST">
                                <input type="hidden" name="productId" value="${producto.getProductID()}">
                                <input type="number" name="cantidad" id="cantidad">
                                <input type="submit" class="btn btn-secondary" name="submit" value="Agregar"> 
                            </form>
                        </div>
                    </div>
                </div>
			</c:forEach>
		</div>
    </div>
</body>
</html>