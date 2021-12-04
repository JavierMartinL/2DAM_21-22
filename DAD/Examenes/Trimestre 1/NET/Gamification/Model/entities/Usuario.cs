using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Usuario
    {
        private string username;
        private string password;
        private string role;
        private bool active;

        public Usuario() { }

        public Usuario(string username, string password, string role, int active)
        {
            this.username = username;
            this.password = password;
            this.role = role;
            this.active = (active == 1) ? true : false ;
        }

        public Usuario(string username, string password, string role, bool active)
        {
            this.username = username;
            this.password = password;
            this.role = role;
            this.active = active;
        }

        public string Username { get => username; set => username = value; }
        public string Password { get => password; set => password = value; }
        public string Role { get => role; set => role = value; }
        public bool Active { get => active; set => active = value; }
    }
}
