using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.entities
{
    public class Paciente
    {
        private string dni;
        private int nhc;
        private string nombre;
        private string apellidos;
        private string direccion;
        private string poblacion;

        public Paciente()
        { }

        public Paciente(string dni, int nhc, string nombre, string apellidos, string direccion, string poblacion)
        {
            this.dni = dni;
            this.nhc = nhc;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.direccion = direccion;
            this.poblacion = poblacion;
        }

        public bool validarDNI(string dni)
        {
            bool dniValido;

            string cadenaLetras = "TRWAGMYFPDXBNJZSQVHLCKET";
            int numDni = int.Parse(dni.Substring(0,8));
            char letraDni = dni.ToUpper().ToCharArray()[8];

            if (numDni >= 0 && numDni <= 99999999)
            {
                int posLetra = numDni % 23;
                char letra = cadenaLetras.ToCharArray()[posLetra];

                if (letra == letraDni) dniValido = true;
                else dniValido = false;
            }
            else
            {
                dniValido = false;
            }
            return dniValido;
        }

        public string Dni { get => dni; set => dni = value; }
        public int Nhc { get => nhc; set => nhc = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Apellidos { get => apellidos; set => apellidos = value; }
        public string Direccion { get => direccion; set => direccion = value; }
        public string Poblacion { get => poblacion; set => poblacion = value; }

        public override string ToString()
        {
            return Nombre + ":" + Apellidos + ":" + Direccion + ":" + " :" + Poblacion + ":" + Dni + ":" + Nhc;
        }
    }
}
