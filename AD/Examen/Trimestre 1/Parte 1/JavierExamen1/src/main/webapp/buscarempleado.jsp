<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<meta name="author" content="Javier Martin Lorenzo" />
	
	<title>Empleados</title>
  
  <link rel="stylesheet"   href="css/bootstrap.min.css" >
</head>
<body>
	
  <main class="container  bg-light">

    <a class="row display-4 text-center navbar-brand " href="index.jsp">
      <h1>
        Gestionar Empleados
      </h1>
    </a>
    <div class="row">
      <h3 class="text-center">
        Buscar Empleados
      </h3>
    </div>
    <div class="row">
      <div class="col-3"></div>
        <form class="col-6  p-3" action="EmpleadoServlet" method="post">
          <div >
            <label for="idempleado" class="form-label">Por ID Empleado: </label>
            <input type="text" class="form-control" id="idempleado" name="idempleado">
          </div>              
          <div >
            <label for="nombre" class="form-label">Por Nombre: </label>
            <input type="text" class="form-control" id="nombre" name="nombre">
            
          </div>

          <div >
            <label for="fechainferior" class="form-label">Inició contrato después de: </label>
            <input type="text" class="form-control" id="fechainferior" placeholder="yyyy-mm-dd" name="fechainferior">
          </div>        
          <div >
            <label for="fechasuperior" class="form-label">Inició contrato antes de: </label>
            <input type="text" class="form-control" id="fechasuperior" placeholder="yyyy-mm-dd" name="fechasuperior">
          </div>                                        
          <div >
            <div class="row p-3">
              <input type="submit" name="submit" class="btn btn-primary btn-lg btn-block col-12" value="Buscar"></input>
            </div>
          </div>
        </form>
      <div class="col-2"></div>
    </div>
    <div class="row">
      <p class="small">
        <b>Nota: </b> si se busca por id no se busca por nada más. Se puede buscar por las dos fechas o por una (si se deja en blanco la otra)
      </p>
    </div>        
    <div class="row">
      <textarea name="datosrecibidos" id="datosrecibidos" cols="10" rows="5" >
      	 ${mensaje}
      </textarea>  
    </div>
  </main>
</body>

</html>