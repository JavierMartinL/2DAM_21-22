![Logo GameMaker Studio 2](https://coal.yoyogames.com/brand/GMS2_PrimaryLogo/Primary1/GMS2_Primary_DblLine_BlackTransparent.png)

<div align="justify">

## Indice

- [Introducción](#introduccion)
- [¿Qué es?](#queEs)
- [Requisitos](#requisitos)
- [Licencias](#licencias)
- [Instalación](#instalacion)
- [Primeros pasos](#primerosPasos)
- [Referencias](#referencias)

<a name="introduccion"></a>
## Introducción

GameMaker Studio 2 es una potente herramienta tanto para principiantes como para profesionales que te permite crear juegos 2D fácilmente. Las herramientas de GameMaker Studio 2 te permiten aprender sin agobios y a tu ritmo,además de organizar las cosas que necesites a tu manera.

<a name="queEs"></a>
## ¿Qué es?

GameMaker Studio 2 dispone de dos forma para desarrollar tu juego, por un lado se encuentra Drag and Drop (DND) y por el otro podemos escoger el lenguaje propio de GameMaker (GML)

### Drag and Drop

<div align="center">

![Drag and Drop](img/DND-GML/DND.png)

</div>

Drag and Drop lo suelen utilizar mayoritariamente los principiantes, y se trata de una herramienta de codificación visual ideal para empezar a crear juegos. 
Se puede elegir lo que se requiera a través de sus gran biblioteca de eventos y acciones para poder plasmar tu idea. 

Además se puede ver “detrás de escena” ya que cuenta con la función de vista previa de código.

### Lenguaje GameMaker (GML)

<div align="center">

![GML](img/DND-GML/GML.png)

</div>

GameMaker lo suelen utilizar personas con más experiencia, ya que se puede utilizar su propio lenguaje de codificación. 


<a name="requisitos"></a>
## Requisitos

Todas las instalaciones de GMS2 requieren al menos 3 GB de espacio libre en el disco duro, una conexión a internet (mínimo una vez al mes) y un sistema operativo de 64 bits para su instalación y ejecución. Solo esta disponible para los sistemas operativos de `Windows` y `Mac`.

<div align="center">

![Descarga de GameMaker Studio 2](img/instalacion/descarga.png)

</div>

| | Minimos | Recomendado |
| -- | -- | -- |
| ***Sistema operativo*** | Windows 7 con SP1 o macOS Mojave | Windows 10 o macOS Catalina |
| ***Procesador*** | CPU de doble núcleo | CPU de cuatros núcleos |
| ***RAM*** | 2GB | 8GB |
| ***Tarjeta gráfica*** | Gráficos integrados compatibles con OpenGL 4 | Gráfica dedicada |
| ***Disco duro*** | HDD | SSD|

<a name="licencias"></a>
## Licencias

| Free | Creator | Indie | Enterprise |
| -- | -- | -- | -- |
| GameMaker Studio 2 | GameMaker Studio 2 | GameMaker Studio 2 | GameMaker Studio 2 |
| Drag and Drop / GML | Drag and Drop / GML | Drag and Drop / GML | Drag and Drop / GML |
| Activos de juego ilimitados | Activos de juego ilimitados | Activos de juego ilimitados | Activos de juego ilimitados |
| Recursos de aprendizaje | Recursos de aprendizaje | Recursos de aprendizaje | Recursos de aprendizaje |
| Comunidad vibrante | Comunidad vibrante | Comunidad vibrante | Comunidad vibrante |
| | Exportaciones de escritorio | Exportaciones de escritorio | Exportaciones de escritorio	|
| | Acceso a la versión beta | Exportación de web | Exportación de web |
| | Acceso a YYC Performance | Exportaciones de móvil | Exportaciones de móvil |
| | Acceso a las extensiones | Exportación UWP | Exportación UWP |
| | | Acceso a la versión beta | PlayStation 4, PlayStation 5* |
| | | Acceso a YYC Performance | Xbox One, Xbox Series X\|S* |
| | | Acceso a las extensiones | Nintendo Switch* |
| | | | Acceso a la versión beta |
| | | | Acceso a YYC Performance |
| | | | Acceso a las extensiones |
| | | | Desarrollo en la línea de comandos |
| ***Gratis*** | ***4,25€/mes*** - ***42,50€/año*** | ***8,19€/mes*** - ***84,99€/año*** | ***67,99€/mes*** - ***679,99€/año*** |

> *Para acceder a las funciones de exportación de la consola, debes ser un desarrollador registrado para la plataforma seleccionada.

<a name="instalacion"></a>
## Instalación

Debemos acceder a la web de GameMaker Studio 2 y crearnos una cuenta para poder descargar el instalador.

<div align="center">

![Crear cuenta GameMaker Studio 2](img/instalacion/login.png)

</div>

Una vez descargado ejecutamos el instalador y solo tenemos que darle siguiente hasta finalizar la instalación.

Para poder utilizar el IDE tenemos que iniciar sesión con la cuenta creada anteriormente.

<div align="center">

![Login desde el IDE](img/instalacion/login_ide.png)

</div>

> Vista principal del IDE

<div align="center">

![IDE](img/instalacion/ide.png)

</div>

<a name="primerosPasos"></a>
## Primeros pasos

Primeramente creamos un nuevo proyecto, dentro de este se crea el sprite al cual le añadiremos una imagen.

<div align="center">

![Crear Juego](img/tutorial/crearJuego.png)

</div>

<div align="center">

![Crear Sprite](img/tutorial/crearSprite.png)

</div>

<div align="center">

![insertar Imagen](img/tutorial/importarImagen.png)

</div>

<div align="center">

![sprite](img/tutorial/sprite.png)

</div>

A continuación creamos un objeto que se le adjuntará el sprite creado anteriormente.

<div align="center">

![sprite](img/tutorial/object.png)

</div>

<div align="center">

![sprite](img/tutorial/add_sprite.png)

</div>

<div align="center">

![sprite](img/tutorial/object_create.png)

</div>

Seguidamente creamos una room,donde se va a visualizar el objeto.

<div align="center">

![Crear room](img/tutorial/room.png)

</div>

<div align="center">

![Agregar jugador room](img/tutorial/add_player_room.png)

</div>

Una vez agregado el objeto al Room debemos agregarle un evento para poder moverlo por dentro de la pantalla

<div align="center">

![Agregar evento](img/tutorial/add-event.png)

</div>

> Evento de tipo Step

<div align="center">

![Evento tipo step](img/tutorial/step.png)

</div>

Creamos una variable para el movimiento

<div align="center">

![Crear Variable](img/tutorial/var.png)

</div>

Agregamos el venteno de pulsar una tecla

<div align="center">

![Crear Variable](img/tutorial/key_down.png)

</div>

Agregamos todas las flechas para poder mover al jugador

<div align="center">

![Pulsacion](img/tutorial/move.png)

</div>

Y para finalizar ya podremos ver el objeto moviéndose en la pantalla.

<div align="center">

![Juego](img/tutorial/game.png)

</div>

<a name="referencias"></a>
## Referencias

- [WEB GameMaker Studio 2](https://www.yoyogames.com/es)
- [Documentación GameMaker Studio 2](https://manual-es.yoyogames.com/#t=Content.htm)
- [Tutoriales](https://www.yoyogames.com/es/tutorials)

> *Creador de contenidos relacionado con GameMaker Studio 2*

- [Adderly Céspedes (youtube)](https://www.youtube.com/channel/UCPyrFm1DOHoTwDPv5kQqARg)
- [WEB de Adderly Céspedes con contenido de GameMaker Studio 2](http://2ddentertainment.com/tut_pag/gm/game_maker.htm)
</div>