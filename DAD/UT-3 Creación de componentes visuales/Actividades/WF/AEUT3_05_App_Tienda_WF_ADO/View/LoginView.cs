using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using Controller;

namespace View
{
    public partial class LoginVIew : Form
    {
        private LoginController loginController;

        public LoginVIew()
        {
            loginController = new LoginController();
            InitializeComponent();
        }

        private void login(object sender, EventArgs e)
        {
            // Recoger los datos del usuario
            int staff = int.Parse(txbStaff.Text);
            string password = txbPassword.Text;
            string rol = null;

            // enviar datos al controlador
            rol = loginController.login(staff, password);
            
        }
    }
}
