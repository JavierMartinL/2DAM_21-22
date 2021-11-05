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
                        int[] opts = Menu.menuEjercicio1();
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
    }
}
