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
    <a class="row display-4 text-center navbar-brand" href="index.jsp">
      <h1>
        Gestionar Empleados
      </h1>
    </a>
    <div class="row">
      <h3 class="text-center">
        Crear Empleado
      </h3>
    </div>
    <div class="row">
      <div class="col-3"></div>

      <form class="col-6  p-3" action="EmpleadoServlet" method="post">
        <div >
          <label for="idempleado" class="form-label">ID Empleado: </label>
          <input type="text" class="form-control" id="idempleado" name="idempleado">
        </div>              
        <div >
          <label for="nombre" class="form-label">Nombre: </label>
          <input type="text" class="form-control" id="nombre" name="nombre">
        </div>
        <div >
          <label for="apellidos" class="form-label">Apellidos: </label>
          <input type="text" class="form-control" id="apellidos" name="apellidos">
        </div>  
        <div >
          <label for="fechacontrato" class="form-label">Fecha de contrato: </label>
          <input type="text" class="form-control" id="fechacontrato" placeholder="yyyy-MM-dd" name="fechacontrato">
        </div>    
        <div >
          <label for="jefe" class="form-label">ID del jefe (en blanco si no tiene): </label>
          <input type="text" class="form-control" id="jefe"  name="jefe">
        </div> 
        <div >
          <div class="row p-3" >
            <label for="direccion" class="form-label">Dirección:</label>
            <div class="col-3">
              <label for="municipio" class="form-label">Municipio:</label>
              <input type="text" class="form-control" id="municipio" name="municipio">
            </div>  
            <div class="col-6">
              <label for="calle" class="form-label">Calle:</label>
              <input type="text" class="form-control" id="calle" name="calle">
            </div>       
            <div class="col-3">
              <label for="numero" class="form-label">Número:</label>
              <input type="text" class="form-control" id="numero" name="numero">
            </div>                                  
          </div>
          <div class="row p-3">
            <input type="submit" name="submit" class="btn btn-primary btn-lg btn-block col-12" value="Crear"></input>
          </div>
        </div>
      </form>

      <div class="col-2"></div>
      
    </div>
    <div class="row">
      <textarea name="datosrecibidos" id="datosrecibidos" cols="10" rows="5">
      	 ${mensaje}
      </textarea>  
    </div>
  </main>
</body>

</html>