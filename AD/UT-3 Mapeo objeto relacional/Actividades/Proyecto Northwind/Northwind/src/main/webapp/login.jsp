<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta name="author" content="Javier Martín Lorenzo" />
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>Login</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		crossorigin="anonymous">
		
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Francois+One&family=Open+Sans:wght@300&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" href="style.css">
</head>

<body>
	<div class="container">
		<div class="row d-flex align-items-lg-center align-items-lg-center align-items-start" style="min-height: 100vh">
			<div class="col-12 col-lg-6 text-center p-3 p-lg-0">
				<h1 class="title">NorthWind</h1>
			</div>
			<div class="col-12 col-lg-6 d-flex justify-content-center">
				<form action="login" method="post" class="form shadow-sm p-3 mb-5 bg-body rounded">
					<div class="form-group m-2">
						<label for="user">Usuario</label>
						<input type="text" name="user" id="user" class="form-control">
					</div>
					<div class="form-group m-2">
						<label for="password">Contraseña</label>
						<input type="password" name="password" id="password" class="form-control">
					</div>
					<div class="mt-3 text-center">
						<input type="submit" class="btn btn-secondary" value="Login">
					</div>
				</form>
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