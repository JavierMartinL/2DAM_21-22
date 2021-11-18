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

        public List<string> leerTodo()
        {
            List<string> texto = new List<string>();

            using (StreamReader sr = File.OpenText(_file))
            {
                string linea;
                while ((linea = sr.ReadLine()) != null)
                {
                    texto.Add(linea);
                }
            }
            return texto;
        }
    }
}
