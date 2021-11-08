using System;
using System.Collections.Generic;
using System.IO;

namespace AEUT3_02_Ejercicios_CS
{
    class Program
    {
        static void Main(string[] args)
        {
            // Se encarga de controlar el bucle que muestra el menú
            bool finalizarEjecucion = false;

            do
            {
                int opt = Menu.menuPrincipal();
                
                switch (opt)
                {
                    case 0:
                        finalizarEjecucion = true;
                        break;

                    /*case 1:
                        int[] opt1 = Menu.menuEjercicio1();
                        break;*/

                    case 2:
                        ejercicio2();
                        break;

                    case 3:
                        ejercicio3();
                        break;

                    case 4:
                        ejercicio4();
                        break;
                    default:
                        break;
                }
            }
            while (!finalizarEjecucion);

        }

        /**
         * 1.- Fechas: Desarrolla el código necesario para que nos muestre por pantalla cuántos días quedan hasta 
         * el DÍA DE CANARIAS (DDC - 30 de mayo) del próximo año ( desde  en día de hoy) y que podamos introducir 
         * una fecha (pidiendo los valores de día, un mes y un año por separados) y nos indique cuántos días quedan 
         * hasta el próximo DDC.
         * 
         * Debes hacerlo de dos maneras distintas:
         *  a) Hazlo utilizando if y elses, y realizando todas las comprobaciones manuales. Debes recordar que el número 
         *  de días varía según el mes. (Aunque no compruebes si el año es bisiesto)
         *  
         *  b) Luego ve a https://msdn.microsoft.com/es-es/library/system.datetime(v=vs.110).aspx y hazlo de manera automática
         */
        private static void ejercicio1()
        {

        }

        /**
         * 2.- Strings: Pedimos un texto y una vez introducido el programa nos preguntará qué acciones queremos 
         * realizar de entre las siguientes (en un menú):
         * 
         * > Buscar una palabra y nos dirá cuántas veces aparece.
         * > Modificar una palabra y nos devolverá el texto de nuevo pero con todas las sustituciones hechas.
         * > Borrar una palabra y nos devolverá el texto de nuevo pero sin la palabra escogida.
         * > Salir
         */
        private static void ejercicio2()
        {
            // Pedir el texto al usuario
            Console.Write("Introduce un texto: ");
            string texto = Console.ReadLine();
            bool finalizar = false;

            do
            {
                int opt = Menu.menuEjercicio2();

                if (opt > 0 && opt < 4)
                {
                    // Pedir la palabra con la que el usuario quiere trabajar
                    Console.Write("Palabra: ");
                    string palabra = Console.ReadLine();
                    string palabraNueva = "";

                    // En caso de que se "modificar" le pedimos al usuario que introduzca la otra palabra
                    if (opt == 2)
                    {
                        Console.Write("\nNueva Palabra: ");
                        palabraNueva = Console.ReadLine();
                    }

                    // buscar/modificar/borrar del texto y lo devolvemos
                    texto = Metodo.accionesTexto(texto, palabra, palabraNueva, opt);
                    Console.WriteLine(texto);
                }
                else if (opt == 0)
                {
                    finalizar = true;
                }
            }
            while (!finalizar);
        }

        /**
         * 3.- Stings: Aplicación bioinformática que deja escribir tantas bases de una cadena de ADN como queramos 
         * (las bases de una cadena de ADN son A,C,G,T) hasta que escribamos la letra F. Con esta cadena debemos obtener:
         * 
         * > cuántas bases de cada tipo n hay (es decir, cuántas A, cuántas C, cuántas G y cuántas T)
         * > cuál de las bases se repite seguido más veces
         * > que codón se repite más (un codón es un triplete de bases, es decir ACG, ATG, CGA,...).
         */
        private static void ejercicio3()
        {
            bool terminarCadena = false;
            string cadena = "";

            do
            {
                Console.Write("Introduce una base [F para terminar]: ");
                string strbase = Console.ReadLine().Substring(0, 1).ToUpper();

                if (strbase == "A" || strbase == "C" || strbase == "T" || strbase == "G")
                {
                    cadena += strbase;
                }
                else if (strbase == "F")
                {
                    terminarCadena = true;
                } 
                else
                {
                    Console.WriteLine("\n\tEl caracter introducido no equivale a una base [A, C, T, G]\n");
                }

            }
            while (!terminarCadena);
            Console.WriteLine();

            Metodo.bioinformatica(cadena);
        }

        /**
         * 4.- Estructuras: Desde la web de www.meteoblue.com Phemos obtenido los datos de las temperaturas de Santa Cruz de Tenerife 
         * desde el mes de octubre en un fichero csv. realiza el código necesario para que nos devuelva cuál ha sido la media 
         * aritmética de las temperaturas máximas, la mínimas y de las medias, y cuál ha tenido más frecuencia (utiliza en 
         * todo momento una precisión de 2 decimales para los valores de las temperaturas).
         * 
         * Utiliza la/s estructura/s de datos que creas mas adecuadas. Para gestionar las temperaturas.
         * 
         * y a demás crea una clase para gestionar los datos del fichero ( intenta que esta clase sea lo mas reutilizable posible 
         * para que la puedas usar en otros desarrollos posteriores).
         */
        private static void ejercicio4()
        {
            ManejoFichero mf = new ManejoFichero("./Files/tiempoTenerife.csv");

            List<string> informacion = mf.leerTodo();

            Console.WriteLine("Temperaturas de Santa Cruz de Tenerife en el mes de Octubre: ");

            Metodo.calcularTemperatura(informacion);
        }
    }
}
