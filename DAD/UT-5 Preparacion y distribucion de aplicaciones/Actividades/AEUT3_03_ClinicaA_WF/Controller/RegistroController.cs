using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model;

namespace Controller
{
    public class RegistroController
    {
        private UserDAO userDAO;

        public RegistroController()
        {
            userDAO = new UserDAO();
        }

        /*
         * Método que crea un usuario para comprobar el login
         */
        public string login(string user, string password)
        {
            // Crear el Usuario
            Usuario usuario = new Usuario(user, password);

            return userDAO.login(usuario);
        }
    }
}
