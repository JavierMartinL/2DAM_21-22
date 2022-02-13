using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    /// <summary>
    /// Clase UserDAO que trabaja con los datos del usuario
    /// </summary>
    public class UserDAO
    {
        private ManejoFichero mf;

        /// <summary>
        /// Constructor que inicializa el fichero de usuarios
        /// </summary>
        public UserDAO()
        {
            mf = new ManejoFichero("./Files/users.txt");
        }

        /// <summary>
        /// Método que con los datos del Usuario comprueba si las credenciales introducidas son válidas
        /// </summary>
        /// <param name="usuario">Objeto Usuario con los datos</param>
        /// <returns>String con el rol del usuario</returns>
        public string login(Usuario usuario)
        {
            string rol = "";
            string[] usuarios = mf.leerTodo().Split('\n');

            for (int i = 0; i < usuarios.Length; i++)
            {
                string[] datosUsuario = usuarios[i].Split(':');

                if (usuario.User.Equals(datosUsuario[0]))
                {
                    if (usuario.Password.Equals(datosUsuario[1]))
                    {
                        rol = datosUsuario[2];
                    }
                }
            }
            return rol;
        }
    }
}
