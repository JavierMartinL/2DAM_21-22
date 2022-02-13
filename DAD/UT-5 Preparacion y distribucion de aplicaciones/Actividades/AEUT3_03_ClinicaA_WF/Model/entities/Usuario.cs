using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Usuario
    {
        private string user;
        private string password;
        private string tipo;

        public Usuario()
        { }

        public Usuario(string user, string password)
        {
            this.user = user;
            this.password = password;
        }

        public Usuario(string user, string password, string tipo)
        {
            this.user = user;
            this.password = password;
            this.tipo = tipo;
        }

        public string User { get => user; set => user = value; }
        public string Password { get => password; set => password = value; }
        public string Tipo { get => tipo; set => tipo = value; }
    }
}
