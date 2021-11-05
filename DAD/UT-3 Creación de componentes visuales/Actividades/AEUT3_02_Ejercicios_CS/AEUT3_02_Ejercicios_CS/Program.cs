using System;

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
                int opt = menu();
                
                switch (opt)
                {
                    case 0:
                        finalizarEjecucion = true;
                        break;

                    case 1:
                        ejercicio1();                        
                        break;

                    case 2:
                        break;

                    case 3:
                        break;

                    case 4:
                        break;
                    default:
                        break;
                }
            }
            while (!finalizarEjecucion);

        }

        private static void ejercicio1()
        {
            menuEjercicio1();
        }

        /**
         * Método encargado de mostrar el menú principal de la aplicación y recoger la opción del usuario
         * @return int Devuelve la opción del usuario
         */
        private static int menu()
        {
            string menu = "\nMenu de los ejercicios: " +
                "\n\t1) Ejercicio 1: Fechas" +
                "\n\t2) Ejercicio 2: Texto" +
                "\n\t3) Ejercicio 3: ADN" +
                "\n\t4) Ejercicio 4: Temperaturas" +
                "\n\t0) Salir" +
                "\n-> ";

            Console.Write(menu);

            // La opción a -1 para evitar que termine la ejecución
            int opt = -1;
            try
            {
                opt = int.Parse(Console.ReadLine());
            }
            catch (Exception ex)
            {
                Console.WriteLine("\n\tERROR: El valor introducido no es válido, tiene que ser un número: \n" + ex.Message);
            }

            Console.WriteLine();
            return opt;
        }

        private static int menuEjercicio1()
        {
            string menuFecha = "\nTipo de fecha: " +
                "\n\t1) Fecha Actual" +
                "\n\t2) Introducir Fecha" +
                "\n\t0) Salir" +
                "\n-> ";

            string menuForma = "\nForma de actuar: " +
                "\n\t1) Manual" +
                "\n\t2) Automática" +
                "\n\t0) Salir" +
                "\n-> ";

            int optFecha = -1;
            int optForma = -1;

            do
            {
                Console.Write(menuFecha);
                try
                {
                    optFecha = int.Parse(Console.ReadLine());
                }
                catch (Exception ex)
                {
                    Console.WriteLine("\n\tERROR: El valor introducido no es válido, tiene que ser un número: \n" + ex.Message);
                }
            }
            while (optFecha < 0 || optFecha > 2);

            if (optFecha != 0)
            {
                do
                {
                    Console.WriteLine(menuForma);
                    try
                    {
                        optForma = int.Parse(Console.ReadLine());
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine("\n\tERROR: El valor introducido no es válido, tiene que ser un número: \n" + ex.Message);
                    }
                }
                while (optForma < 0 || optForma > 2);
            }

            return 0;
        }
    }
}
