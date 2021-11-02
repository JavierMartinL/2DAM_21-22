<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">

        <title>Crear Usuario</title>
    </head>
    <body class="fondo">
        <div class="container">
            <div class="row vh-100 justify-content-center align-items-center">
                <div class="col-11 col-sm-10 col-md-8 col-lg-5 bg-light p-5 shadow-lg mb-5 bg-body rounded">
                    <h3 class="text-center">Se debe crear un nick para jugar:</h3>
                    <form action="" method="POST">
                        <div class="input-group p-2">
                            <input type="text" class="form-control" placeholder="Nick usuario:" name="nick" id="nick"/>
                        </div>
                        <input type="submit" class="btn btn-success w-100" value="Crear"/>
                    </form>
                </div>
            </div>
        </div>
        
        
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>