using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    class Usuario
    {
        private string user;
        private string password;
        private string tipo;

        public Usuario()
        { }

        public Usuario(string user, string password, string tipo)
        {
            this.user = user;
            this.password = password;
            this.tipo = tipo;
        }

        public void guardar(string user, string password)
        {
            Console.WriteLine(user);
            Console.WriteLine(password);
        }
    }
}
