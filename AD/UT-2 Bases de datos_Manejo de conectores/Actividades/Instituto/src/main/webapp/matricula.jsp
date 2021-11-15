<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Javier Martin Lorenzo" />
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    <!-- FontAwesome -->
    <link href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' rel='stylesheet'>
    
    <!-- Estilo CSS -->
    <link href="css/style.css" rel="stylesheet">
    
    <title>Gestionar Matrículas</title>
</head>

<body>

    <div class="container-fluid">

        <div class="row">
            <div class="col-12">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                      <a class="navbar-brand" href="./index.html"><i class="fas fa-home"></i></a>
                      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                      </button>
                      <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" href="Alumnos">Alumno</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="Asignaturas">Asignatura</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Matriculas">Matrícula</a>
                            </li>
                        </ul>
                      </div>
                    </div>
                </nav>
            </div>
        </div>

        <!-- Titulo -->
        <div class="row">
            <div class="col-12 mt-5 text-center">
                <h1>Gestionar Instituto</h1>
            </div>
        </div>

        <div class="row">
            <div class="col-12 text-center">
                <h3>Matrículas</h3>
            </div>
        </div>

        <!-- Formularios -->
        <div class="row mt-3">
            <div class="col-10 offset-1">
                <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link text-dark active" id="agregar-tab" data-bs-toggle="tab" data-bs-target="#agregar" type="button" role="tab" aria-controls="agregar" aria-selected="true">Agregar</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link text-dark" id="borrar-tab" data-bs-toggle="tab" data-bs-target="#borrar" type="button" role="tab" aria-controls="borrar" aria-selected="false">Borrar</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link text-dark" id="editar-tab" data-bs-toggle="tab" data-bs-target="#editar" type="button" role="tab" aria-controls="editar" aria-selected="false">Editar</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link text-dark" id="mostrar-tab" data-bs-toggle="tab" data-bs-target="#mostrar" type="button" role="tab" aria-controls="mostrar" aria-selected="false">Mostrar</button>
                    </li>
                </ul>

                <div class="tab-content p-2 rounded-bottom" id="myTabContent" style="background-color: white;">
                    <!-- Formulario para agregar una nueva Matrícula -->
                    <div class="tab-pane fade show active" id="agregar" role="tabpanel" aria-labelledby="agregar-tab">
                        <form action="Matriculas" method="POST">
                            <div class="mb-3">
                                <label for="dni" class="form-label">DNI Alumno <span class="text-danger align-text-top">*</span></label>
                                <input type="text" name="dni" id="dni" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label for="anio" class="form-label">Año <span class="text-danger align-text-top">*</span></label>
                                <input type="text" name="anio" id="anio" class="form-control" required>
                            </div>

                            <div class="mb-3">
                                <label for="asignaturas" class="form-label">Asignaturas <span class="text-danger align-text-top">*</span></label>
                                <input type="text" name="asignaturas" id="asignaturas" class="form-control" required>
                            </div>

                            <div class="col-12 text-center">
                                <input type="submit" name="submit" value="Agregar" class="btn btn-secondary">
                            </div>
                        </form>
                    </div>

                    <!-- Formulario para borrar una Matricula -->
                    <div class="tab-pane fade" id="borrar" role="tabpanel" aria-labelledby="borrar-tab">
                        <form action="Matriculas" method="POST">
                            <div class="mb-3">
                                <label for="id" class="form-label">ID Matrícula <span class="text-danger align-text-top">*</span></label>
                                <input type="text" name="id" id="id" class="form-control" required>
                            </div>

                            <div class="col-12 text-center">
                                <input type="submit" name="submit" value="Borrar" class="btn btn-secondary">
                            </div>
                        </form>
                    </div>

                    <!-- Formulario para editar una Matricula -->
                    <div class="tab-pane fade" id="editar" role="tabpanel" aria-labelledby="editar-tab">
                        <form action="Matriculas" method="POST">
                            <div class="mb-3">
                                <label for="id" class="form-label">ID Matrícula <span class="text-danger align-text-top">*</span></label>
                                <input type="text" name="id" id="id" class="form-control" required>
                            </div>

                            <div class="mb-3">
                                <label for="dni" class="form-label">DNI Alumno <span class="text-danger align-text-top">*</span></label>
                                <input type="text" name="dni" id="dni" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label for="anio" class="form-label">Año <span class="text-danger align-text-top">*</span></label>
                                <input type="text" name="anio" id="anio" class="form-control" required>
                            </div>

                            <div class="mb-3">
                                <label for="asignaturas" class="form-label">Asignaturas <span class="text-danger align-text-top">*</span></label>
                                <input type="text" name="asignaturas" id="asignaturas" class="form-control" required>
                            </div>

                            <div class="col-12 text-center">
                                <input type="submit" name="submit" value="Editar" class="btn btn-secondary">
                            </div>
                        </form>
                    </div>

                    <!-- Formulario para mostrar una Matricula -->
                    <div class="tab-pane fade" id="mostrar" role="tabpanel" aria-labelledby="mostrar-tab">
                        <form action="Matriculas" method="POST">
                            <div class="input-group mt-3 mb-3">
                                <select class="form-select" name="option" id="option">
                                    <option value="" selected>Busquedas...</option>
                                    <option value="todo">Mostrar todas las Matrículas</option>
                                    <option value="id">Mostrar una Matrículas por ID</option>
                                    <option value="anio">Mostrar todas las Matrículas de un Año</option>
                                    <option value="dni">Mostrar todas las Matrículas de un Alumno</option>
                                </select>
                                <label class="input-group-text" for="inputGroupSelect02">Busquedas</label>
                            </div>

                            <div class="mb-3" id="idOption" style="display: none;">
                                <label for="id" class="form-label">ID Matrícula <span class="text-danger align-text-top"></span></label>
                                <input type="text" name="id" id="id" class="form-control">
                            </div>

                            <div class="mb-3" id="anioOption" style="display: none;">
                                <label for="anio" class="form-label">Año <span class="text-danger align-text-top"></span></label>
                                <input type="text" name="anio" id="anio" class="form-control">
                            </div>

                            <div class="mb-3" id="dniOption" style="display: none;">
                                <label for="dni" class="form-label">DNI Alumno <span class="text-danger align-text-top"></span></label>
                                <input type="text" name="dni" id="dni" class="form-control">
                            </div>
                            
                            <div class="col-12 text-center">
                                <input type="submit" name="submit" id="submitMostrar" value="Mostrar" class="btn btn-secondary" style="visibility: hidden;">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Mostrar JSON -->
        <c:if test="${mensaje != null && !mensaje.isEmpty()}">
            <div class="row mt-5">
                <div class="col-10 offset-1" st>
                    <textarea class="form-control" rows="10" cols="50">
                        ${mensaje}
                    </textarea>
                </div>
            </div>
        </c:if>

        <!-- Mostrar errores -->
        <c:if test="${error != null && !error.isEmpty()}">    
            <div class="row mt-1 d-flex justify-content-center">
                <div class="col-auto">
                    <div class="alert alert-danger d-flex align-items-center" role="alert">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
                            <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                        </svg>
                        <div>
                            ${error}
                        </div>
                    </div>
                </div>
            </div>
        </c:if>

    </div>
    
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Evitar volver a enviar el formulario al recargar la pagina -->
    <script>
        if ( window.history.replaceState ) {
            window.history.replaceState( null, null, window.location.href );
        };

        document.getElementById("option").addEventListener("click", function() {

            switch (this.value) {
                case "":
                    document.getElementById("idOption").style.display = "none";
                    document.getElementById("anioOption").style.display = "none";
                    document.getElementById("dniOption").style.display = "none";
                    document.getElementById("submitMostrar").style.visibility = "hidden";
                    break;

                case "todo":
                    document.getElementById("idOption").style.display = "none";
                    document.getElementById("anioOption").style.display = "none";
                    document.getElementById("dniOption").style.display = "none";
                    document.getElementById("submitMostrar").style.visibility = "visible";
                    break;

                case "id":
                    document.getElementById("idOption").style.display = "block";
                    document.getElementById("anioOption").style.display = "none";
                    document.getElementById("dniOption").style.display = "none";
                    document.getElementById("submitMostrar").style.visibility = "visible";
                    break;

                case "anio":
                    document.getElementById("idOption").style.display = "none";
                    document.getElementById("anioOption").style.display = "block";
                    document.getElementById("dniOption").style.display = "none";
                    document.getElementById("submitMostrar").style.visibility = "visible";
                    break;

                case "dni":
                    document.getElementById("idOption").style.display = "none";
                    document.getElementById("anioOption").style.display = "none";
                    document.getElementById("dniOption").style.display = "block";
                    document.getElementById("submitMostrar").style.visibility = "visible";
                    break;
            }
        });
    </script>
</body>

</html>