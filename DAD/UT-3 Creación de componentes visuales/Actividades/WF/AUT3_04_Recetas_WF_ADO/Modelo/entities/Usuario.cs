using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
    public class Usuario
    {
        private int id;
        private string nombre;
        private string password;
        private string rol;

        public Usuario() { }

        public Usuario(int id, string nombre, string password, string rol)
        {
            this.id = id;
            this.nombre = nombre;
            this.password = password;
            this.rol = rol;
        }

        public int Id { get => id; set => id = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Password { get => password; set => password = value; }
        public string Rol { get => rol; set => rol = value; }
    }
}
