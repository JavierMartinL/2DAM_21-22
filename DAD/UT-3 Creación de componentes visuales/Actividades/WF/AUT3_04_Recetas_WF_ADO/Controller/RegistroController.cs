using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Modelo;
using Modelo.dao;

namespace Controller
{
    public class RegistroController
    {
        private UsuarioDAO usuarioDAO;

        public RegistroController()
        {
            usuarioDAO = new UsuarioDAO();
        }

        /*
         * Método que comprueba que la contraseña introducida es igual a la del usuario y devuelve el rol del usuario
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
                    rol = usuario.Rol;
                }
            }
            return rol;
        }

    }
}
