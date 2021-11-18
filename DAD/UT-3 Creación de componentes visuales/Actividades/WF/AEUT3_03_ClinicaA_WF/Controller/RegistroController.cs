using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller
{
    public class RegistroController
    {
        Model.UserDAO userDAO = new Model.UserDAO();
        public RegistroController()
        {
        }

        public string login(string user, string password)
        {
            string respuesta = "";
            userDAO.leer();
            if (user.Equals("Javier") && password.Equals("1234"))
            {
                respuesta = "personalsanitario";
                
            }
            return respuesta;
        }
    }
}
