using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model;

namespace Controller
{
    /// <summary>
    /// Controlador de la vista de Login
    /// </summary>
    public class ControllerLogin
    {
        ModelLogin model;

        /// <summary>
        /// Constructor que inicializa el modelo de Login
        /// </summary>
        public ControllerLogin()
        {
            model = new ModelLogin();
        }

        /// <summary>
        /// Método que a partir de los datos de un usuarios comprobar el login
        /// </summary>
        /// <param name="id_staff">Identificador del usuario</param>
        /// <param name="password">Contraseña del usuario</param>
        /// <returns>Objeto usuario con todos sus datos</returns>
        public Users loginUser(int id_staff, string password)
        {

            Users result = model.obtenirUsuari(new Users(id_staff, password));
           
            return result;
        }
    }
}
