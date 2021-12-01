using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model;
using Model.entities;

namespace Controller
{
    public class LoginController
    {
        private UsuarioDAO usuarioDAO;

        public LoginController()
        {
            usuarioDAO = new UsuarioDAO();
        }

        /*
         * Método que comprueba que la contraseña introducida es igual a la del usuario y devuelve el rol del usuario
         */
        public bool login(int idStaff, string password)
        {
            bool loginOK = false;
            // Recoger los datos del Usuario
            Usuario usuario = usuarioDAO.findById(idStaff);

            if (usuario != null)
            {
                // Comprobar que la contraseña es igual a la que esta guardada en la base de datos
                if (usuario.Password.Equals(password))
                {
                    loginOK = true;
                }
            }
            return loginOK;
        }
    }
}
