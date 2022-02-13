using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model;

namespace Controller
{
    /// <summary>
    /// Controlador del Registro
    /// </summary>
    public class RegistroController
    {
        private UserDAO userDAO;

        /// <summary>
        /// Constructor que inicializa la clase UserDAO
        /// </summary>
        public RegistroController()
        {
            userDAO = new UserDAO();
        }

        /// <summary>
        /// Método que crea un usuario para comprobar el login
        /// </summary>
        /// <param name="user">Nombre del usuario</param>
        /// <param name="password">Contraseña del usuario</param>
        /// <returns>String con el Rol del usuario</returns>
        public string login(string user, string password)
        {
            // Crear el Usuario
            Usuario usuario = new Usuario(user, password);

            return userDAO.login(usuario);
        }
    }
}
