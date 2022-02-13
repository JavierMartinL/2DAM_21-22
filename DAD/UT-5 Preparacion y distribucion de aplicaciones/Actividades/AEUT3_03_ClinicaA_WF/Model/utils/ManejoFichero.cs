using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    /// <summary>
    /// Clase encargada del manejo de ficheros
    /// </summary>
    class ManejoFichero
    {
        private string _file;

        /// <summary>
        /// Contructor que almacena la ruta de un fichero
        /// </summary>
        /// <param name="path">Ruta del fichero</param>
        public ManejoFichero(string path)
        {
            _file = path;
        }

        /// <summary>
        /// Método que recorre el fichero y devuelve el contenido
        /// </summary>
        /// <returns>string con el contenido del fichero</returns>
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

        /// <summary>
        /// Método que inserta datos al final de fichero en una nueva línea
        /// </summary>
        /// <param name="datos">Datos que queremos agregar al fichero</param>
        public void guardarFinal(string datos)
        {
            File.AppendAllText(_file, datos + '\n');
        }

        /// <summary>
        /// Método que elimina una linea si coinciden los valores
        /// </summary>
        /// <param name="pos">Posicion del dato</param>
        /// <param name="value">Contenido del dato</param>
        /// <returns>True si se ha eliminado algun dato, False si no se elimina nada</returns>
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
