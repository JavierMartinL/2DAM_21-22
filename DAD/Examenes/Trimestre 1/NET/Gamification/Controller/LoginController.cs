using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model;
using Model.dao;

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
         * Método que comprueba que la contraseña introducida es igual a la del usuario
         * si es correcto devuelve el rol del usuario
         */
        public string login(string user, string password)
        {
            string rol = "";
            // Recoger los datos del Usuario
            Usuario usuario = usuarioDAO.findByName(user);

            if (usuario != null)
            {
                // Comprobar que la contraseña es igual a la que esta guardada en la base de datos
                if (usuario.Password.Equals(password))
                {
                    // Si el usuario esta activo
                    if (usuario.Active)
                    {
                        rol = usuario.Role;
                    }
                    // Si no enviamos el rol inactivo
                    else
                    {
                        rol = "inactivo";
                    }
                }
            }
            return rol;
        }
    }
}
