using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.entities
{
    /// <summary>
    /// Clase Paciente
    /// </summary>
    public class Paciente
    {
        private string dni;
        private int nhc;
        private string nombre;
        private string apellidos;
        private string direccion;
        private string poblacion;

        /// <summary>
        /// Constructor por defecto
        /// </summary>
        public Paciente()
        { }

        /// <summary>
        /// Constructor con parámetros
        /// </summary>
        /// <param name="dni">DNI del paciente</param>
        /// <param name="nhc">NHC del paciente</param>
        /// <param name="nombre">Nombre del paciente</param>
        /// <param name="apellidos">Apellidos del paciente</param>
        /// <param name="direccion">Dirección del paciente</param>
        /// <param name="poblacion">Poblacion del paciente</param>
        public Paciente(string dni, int nhc, string nombre, string apellidos, string direccion, string poblacion)
        {
            this.dni = dni;
            this.nhc = nhc;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.direccion = direccion;
            this.poblacion = poblacion;
        }

        /// <summary>
        /// Método que válida un DNI
        /// </summary>
        /// <param name="dni">DNI a validar</param>
        /// <returns>TRUE si el DNI es valido, FALSE si no es valido</returns>
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

        /// <summary>
        /// Getter y Setter del DNI
        /// </summary>
        public string Dni { get => dni; set => dni = value; }

        /// <summary>
        /// Getter y Setter del NHC
        /// </summary>
        public int Nhc { get => nhc; set => nhc = value; }

        /// <summary>
        /// Getter y Setter del nombre
        /// </summary>
        public string Nombre { get => nombre; set => nombre = value; }

        /// <summary>
        /// Getter y Setter de los apellidos
        /// </summary>
        public string Apellidos { get => apellidos; set => apellidos = value; }

        /// <summary>
        /// Getter y Setter de la direccion
        /// </summary>
        public string Direccion { get => direccion; set => direccion = value; }

        /// <summary>
        /// Getter y Setter de la poblacion
        /// </summary>
        public string Poblacion { get => poblacion; set => poblacion = value; }

        /// <summary>
        /// Método que devuelve todos los datos de un paciente
        /// </summary>
        /// <returns>String con los datos separados por ":" para poder agregarlo a un fichero</returns>
        public override string ToString()
        {
            return Nombre + ":" + Apellidos + ":" + Direccion + ":" + " :" + Poblacion + ":" + Dni + ":" + Nhc;
        }
    }
}
