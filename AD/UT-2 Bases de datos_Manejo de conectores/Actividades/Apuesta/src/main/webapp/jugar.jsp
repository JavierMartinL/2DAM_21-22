<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link rel="stylesheet" href="css/style.css">

		<title>Jugar</title>
	</head>
	<body class="fondo">

		<div class="container overflow-hidden">
			<div class="row justify-content-center align-items-center m-3">
				<div class="col-12 col-md-4 bg-light p-4 shadow-lg mb-5 bg-body rounded">
                    <form action="" method="POST">
                        <div class="input-group p-2">
                            <input type="text" class="form-control" placeholder="Apuesta:" name="apuesta" id="apuesta"/>
                        </div>
                        <input type="submit" class="btn btn-success w-100" value="Apostar"/>
                    </form>
                </div>
				<div class="col-12 col-md-7 offset-md-1 bg-light p-3 shadow-lg mb-5 bg-body rounded">
					<div>
						<h5 class="mb-0">Usuario:</h5> 
						<span class="ms-3 fst-italic">${nickSession}</span>
					</div>
					<c:if test="${ultimoGanador != null }">
						<div class="mt-2">
							<h5 class="mb-0">Último ganador:</h5>
							<ul>
								<li class="fst-italic"><span class="fw-light"> Usuario Ganador: </span>${ultimoGanador.getNickGanador()}</li>
								<li class="fst-italic"><span class="fw-light"> Secreto: </span>${ultimoGanador.getNumero()}</li>
								<li class="fst-italic"><span class="fw-light"> Hora: </span>${horaAcierto}</li>
							</ul>
						</div>
					</c:if>
					<div class="mt-2">
						<h5 class="mb-0">Hora del actual secreto:</h5> 
						<span class="ms-3 fst-italic">${horaCreacion}</span>
					</div>
				</div>
			</div>
			<div class="row justify-content-center align-items-center m-3">
				<div class="col-12 col-md-6 bg-light p-3 shadow-lg mb-5 bg-body rounded overflow-auto">
					<div class="row" style="max-height: 500px">
						<c:forEach items="${apuestas}" var="apuesta">
							<c:choose>
								<c:when test="${apuesta.getValue() > secreto.getNumero()}">
									<div class="col-6 col-lg-4 col-xl-3">secreto < ${apuesta.getValue()}</div>
								</c:when>
								<c:when test="${apuesta.getValue() < secreto.getNumero()}">
									<div class="col-6 col-lg-4 col-xl-3">secreto > ${apuesta.getValue()}</div>
								</c:when>
								<c:otherwise>
									<div class="col-12 text-center fs-4 mt-3">¡¡Acertaste!! secreto = ${apuesta.getValue()}</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
				</div>
				<div class="col-12 col-md-5 offset-md-1 bg-light p-3 shadow-lg mb-5 bg-body rounded text-center">
					<h3>TOP 10</h3>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Nick</th>
								<th scope="col">Secreto</th>
								<th scope="col">Tiempo (s)</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ganadores}" var="ganador">
								<tr>
									<td>${ganador.getNickGanador()}</td>
									<td>${ganador.getNumero()}</td>
									<td>${ganador.getCantTiempoAcierto()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
	</body>
</html>