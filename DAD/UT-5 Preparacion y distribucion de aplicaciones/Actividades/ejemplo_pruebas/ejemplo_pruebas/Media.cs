using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ejemplo_pruebas
{
    public class Media
    {
        static void Main()
        {
            int media = 0;

            

            //en este caso le añadimos una lista definida
            int[] llista = { 10, 16 };

            media = calculo_media(llista);

            Console.Write("La miedia és: {0}", media);
            Console.ReadLine();

        }
        static public int calculo_media(int[] llista)
        {
            int suma = 0;
            int contador = 0;
            int numero = 0;
            int i = 0;


            //  Nodo1
            do
            {
                numero = llista[contador];
                //  Nodo2
                if (numero >= 10 && numero <= 20)
                {
                    //  Nodo3
                    suma = suma + numero;
                    contador++;
                }
                else
                {
                    //  Nodo4
                    Console.WriteLine("Error. Debes ser un número correcto");

                }
                //  Nodo5
                //contador++;
                i++;
            }
            //while (contador < llista.Length);
            while (i < llista.Length); //  Nodo6

            if (contador == 0) return 0;
            
            return suma / contador;//  Nodo7
        }
    }
   
}