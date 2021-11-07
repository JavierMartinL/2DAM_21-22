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
                int opt = Menu.menuPrincipal();
                
                switch (opt)
                {
                    case 0:
                        finalizarEjecucion = true;
                        break;

                    case 1:
                        int[] opt1 = Menu.menuEjercicio1();
                        break;

                    case 2:
                        ejercicio2();
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

        private static void ejercicio2()
        {
            Console.Write("Introduce un texto: ");
            string texto = Console.ReadLine();
            bool finalizar = false;

            do
            {
                int opt = Menu.menuEjercicio2();

                if (opt > 0 && opt < 4)
                {
                    Console.Write("Palabra: ");
                    string palabra = Console.ReadLine();
                    string palabraNueva = "";

                    if (opt == 2)
                    {
                        Console.Write("\nNueva Palabra: ");
                        palabraNueva = Console.ReadLine();
                    }

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
    }
}
