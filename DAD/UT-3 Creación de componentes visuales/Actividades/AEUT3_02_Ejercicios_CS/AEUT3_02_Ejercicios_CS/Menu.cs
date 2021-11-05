using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AEUT3_02_Ejercicios_CS
{
    class Menu
    { 
        /**
         * Método encargado de mostrar el menú principal de la aplicación y recoger la opción del usuario
         * @return int Devuelve la opción del usuario
         */
        public static int menuPrincipal()
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

        /**
         * Método que se encarga de mostrar los dos submenús del ejercicio 1
         * > menuFecha sirve para elegir si queremos la fecha actual o introducida por el usuario
         * > menuForma sirve para que el cálculo sea manual o automático
         * @return
         */
        public static int[] menuEjercicio1()
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

            int[] opts = new int[2] {optFecha, optForma};

            do
            {
                Console.Write(menuFecha);
                try
                {
                    optFecha = int.Parse(Console.ReadLine());
                    opts[0] = optFecha;
                    
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
                    Console.Write(menuForma);
                    try
                    {
                        optForma = int.Parse(Console.ReadLine());
                        opts[1] = optForma;
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine("\n\tERROR: El valor introducido no es válido, tiene que ser un número: \n" + ex.Message);
                    }
                }
                while (optForma < 0 || optForma > 2);
            }
            return opts;
        }
    }
}
