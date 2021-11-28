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

        public string login(string user, string password)
        {
            string rol = "";
            Usuario usuario = usuarioDAO.findByName(user);

            if (usuario != null)
            {
                if (usuario.Password.Equals(password))
                {
                    rol = usuario.Rol;
                }
            }
            return rol;
        }

    }
}
