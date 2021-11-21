﻿using System;
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
    }
}
