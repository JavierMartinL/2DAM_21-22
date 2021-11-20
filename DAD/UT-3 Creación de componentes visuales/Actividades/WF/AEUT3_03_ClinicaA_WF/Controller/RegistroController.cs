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

        public string login(string user, string password)
        {
            Usuario usuario = new Usuario(user, password);

            return userDAO.login(usuario);
        }
    }
}
