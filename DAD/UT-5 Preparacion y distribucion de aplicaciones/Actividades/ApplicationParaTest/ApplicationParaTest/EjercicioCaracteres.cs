using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ApplicationParaTest
{
    public class EjercicioCaracteres
    {
        /// <summary>
        /// EXERCICIO CARACTERES PRA TEST
        /// </summary>
        static void Main(string[] args)
        {

            String resultado = "";
            String texto = "";

            texto = leerArchivo("frases.txt");
            if (texto.Equals("")) Console.WriteLine("\nEl programa tiene problemas con el archivo!Vuelve a intentarlo mas tarde");
            else
            {

                resultado = transformaTexto(texto);

                Console.WriteLine(resultado);


                //contamos el numero de vocales por separado mediante el diccionario
                recuentoVocales(resultado);


            }
            Console.ReadLine();
        }
        /// <summary>
        /// 
        /// Metodo que transforma la cadena de caracteres sin espacios, acentos, en minúsculas,
        /// dada la vuelta y con las vocales en mayúsculas
        /// </summary>
        /// <param name="texto"></param>
        /// <returns></returns>
        public static string transformaTexto(string texto)
        {

            String result = "";
            //eliminar espacios en blanco
            result = texto.Replace(" ", "");

            //darle la vuelta a la cadena
            result = darVuelta(result);

            //pasarlo todo a minusculas , así pasar a mayuscula las vocales es mas fácil
            result = result.ToLower();

            //sacar accents
            result = sacarAcentos(result);

            //en este momento tenemos la cadena sin espacios, acentos, en minúsculas y dada la vuelta

            //pasamos las vocales a mayúsculas
            result = result.Replace("a", "A").Replace("e", "E").Replace("i", "I").Replace("o", "O").Replace("u", "U");

            return result;

        }

        /// <summary>
        /// este método nos proporciona cuantas  a, e, i, o, u tenemos en la frase una vez transformada
        /// </summary>
        /// <param name="result"> Cadena que contiene el fichero. No tiene espacios, ni accentos,... </param>
        private static void recuentoVocales(String result)
        {

            Dictionary<string, int> contadores = new Dictionary<string, int>();
            int posicion;
            //iniciamos el  diccionario a -1
            contadores["A"] = -1;
            contadores["E"] = -1;
            contadores["I"] = -1;
            contadores["O"] = -1;
            contadores["U"] = -1;

            //recorremos el diccionario lletra a lletra (keys)
            //ojo, para que sobreescriba el diccionario debemos añadir el ToList que ves debajo!!
            foreach (var item in contadores.Keys.ToList())
            {
                posicion = -1;

                do
                {
                    posicion = result.IndexOf(item, posicion + 1);
                    contadores[item]++;

                } while (posicion != -1);
            }



            foreach (var key in contadores.Keys)
            {
                Console.WriteLine("Tenemos {1} - {0}", key, contadores[key]);
                Console.WriteLine();
            }
        }

        /// <summary>
        /// Este método quita los acentos que existen en catalán/castellano 
        /// </summary>
        /// <param name="result">Cadena que contiene el archivo. Result no tiene espacios, está dada la vuelta y en minúsculas</param>
        /// <returns></returns>
        public static string sacarAcentos(string result)
        {
            char[] vocalesA = { 'à', 'á', 'è', 'é', 'í', 'ò', 'ó', 'ú', 'ï', 'ü' };
            char[] vocales = { 'a', 'a', 'e', 'e', 'i', 'o', 'o', 'u', 'i', 'u' };
            for (int i = 0; i < vocales.Length; i++)
            {
                result = result.Replace(vocalesA[i], vocales[i]);
            }
            return result;
        }

        /// <summary>
        /// Método que da una cadena le da la vuelta
        /// </summary>
        /// <param name="result">Cadena que contiene el archivo. Result no contiene espacios</param>
        /// <returns></returns>
        public static string darVuelta(string result)
        {
            char[] charsOfResult = new char[100];//supongamos que el archivo no tiene demasiados caracteres!!!

            charsOfResult = result.ToCharArray();
            char[] reversed = charsOfResult.Reverse().ToArray();
            result = new string(reversed);

            return result;
        }

        /// <summary>
        /// Método que lee el archivo y lo pasa a una cadena
        /// </summary>
        /// <returns>  La cadena que contiene el archivo </returns>
        public static String leerArchivo(string urlFichero)
        {
            String result = "";
            try
            { // Nodo 1
                using (StreamReader sr = new StreamReader(urlFichero))
                {
                    string line;
                    // Nodo 2
                    while ((line = sr.ReadLine()) != null)
                    {
                        // Nodo 3
                        result += line;
                    }
                }
            }
            catch (Exception e)
            {

                Console.WriteLine("The file could not be read!");
                // Console.WriteLine(e.Message);
            }
            // Nodo Final
            return result;
        }
    }
}
