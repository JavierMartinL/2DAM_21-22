using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    class ManejoFichero
    {
        private string _file;

        public ManejoFichero(string path)
        {
            _file = path;
        }

        /*
         * Método que recorre el fichero y devuelve los datos en un string
         */
        public string leerTodo()
        {
            string texto = "";

            using (StreamReader sr = File.OpenText(_file))
            {
                string linea;
                while ((linea = sr.ReadLine()) != null)
                {
                    texto += linea + "\n";
                }
            }
            return texto;
        }

        /*
         * Método que inserta al final de fichero una nueva línea
         */
        public void guardarFinal(string datos)
        {
            File.AppendAllText(_file, datos + '\n');
        }

        /*
         * Método que elimina una linea si coinciden los valores
         */
        public bool eliminarFila(int pos, string value)
        {
            bool cambios = false;

            // Crear fichero temporal
            string temp = _file.Replace(".txt", "-temp.txt");
            using (var sr = new StreamReader(_file))
            using (var sw = new StreamWriter(temp))
            {
                string line;

                while ((line = sr.ReadLine()) != null)
                {
                    // Si en la posición indicada coincide el valor no se escribe esa linea
                    if (line.Split(':')[pos] != value)
                    {
                        sw.WriteLine(line);
                        cambios = true;
                    }
                }
            }

            // Eliminar el fichero y convertir el temporal en el nuevo fichero
            File.Delete(_file);
            File.Move(temp, _file);
            return cambios;
        }
    }
}
