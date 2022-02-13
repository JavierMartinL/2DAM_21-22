using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    /// <summary>
    /// Clase Usuario
    /// </summary>
    public class Usuario
    {
        private string user;
        private string password;
        private string tipo;

        /// <summary>
        /// Constructor por defecto
        /// </summary>
        public Usuario()
        { }

        /// <summary>
        /// Constructor con dos parámetros
        /// </summary>
        /// <param name="user">Nombre del usuario</param>
        /// <param name="password">Contraseña del usuario</param>
        public Usuario(string user, string password)
        {
            this.user = user;
            this.password = password;
        }

        /// <summary>
        /// Constructor con tres parámetros
        /// </summary>
        /// <param name="user">Nombre del usuario</param>
        /// <param name="password">Contraseña del usuario</param>
        /// <param name="tipo">Rol del usuario</param>
        public Usuario(string user, string password, string tipo)
        {
            this.user = user;
            this.password = password;
            this.tipo = tipo;
        }

        /// <summary>
        /// Getter y Setter del nombre
        /// </summary>
        public string User { get => user; set => user = value; }

        /// <summary>
        /// Getter y Setter de la contraseña
        /// </summary>
        public string Password { get => password; set => password = value; }

        /// <summary>
        /// Getter y Setter del rol
        /// </summary>
        public string Tipo { get => tipo; set => tipo = value; }
    }
}
