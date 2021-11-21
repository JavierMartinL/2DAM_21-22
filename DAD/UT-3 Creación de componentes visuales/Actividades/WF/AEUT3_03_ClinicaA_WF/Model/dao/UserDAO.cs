using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class UserDAO
    {
        private ManejoFichero mf;

        public UserDAO()
        {
            mf = new ManejoFichero("./Files/users.txt");
        }

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
