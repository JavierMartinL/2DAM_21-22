using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Users
    {
        private int id_staff;
        private String password;
        private String role;

        public Users(int id_staff, String password)
        {
            this.id_staff = id_staff;
            this.password = password;
            this.role = null;
        }
        public Users(int id_staff, String password, String role)
        {
            this.id_staff = id_staff;
            this.password = password;
            this.role = role;
        }

        public int Id_staff
        {
            get
            {
                return id_staff;
            }

            set
            {
                id_staff = value;
            }
        }

        public string Password
        {
            get
            {
                return password;
            }

            set
            {
                password = value;
            }
        }

        public string Role
        {
            get
            {
                return role;
            }

            set
            {
                role = value;
            }
        }
    }
}
