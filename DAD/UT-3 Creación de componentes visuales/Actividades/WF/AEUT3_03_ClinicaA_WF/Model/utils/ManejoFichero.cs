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

        public void guardarFinal(string datos)
        {
            File.AppendAllText(_file, datos + '\n');
        }
    }
}
