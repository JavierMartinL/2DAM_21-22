using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.entities
{
    public class Usuario
    {
        private int idStaff;
        private string password;
        private string rol;

        public Usuario() { }

        public Usuario(int idStaff, string password, string rol)
        {
            this.idStaff = idStaff;
            this.password = password;
            this.rol = rol;
        }

        public int IdStaff { get => idStaff; set => idStaff = value; }
        public string Password { get => password; set => password = value; }
        public string Rol { get => rol; set => rol = value; }
    }
}
