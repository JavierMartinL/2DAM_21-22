using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace View
{
    public partial class RegistroView : Form
    {
        Controller.RegistroController registroController = new Controller.RegistroController();
        public RegistroView()
        {
            InitializeComponent();
        }

        private void login(object sender, EventArgs e)
        {
            bool error = false;
            string user = txbUser.Text;
            string password = txbPassword.Text;

            lblErrorUser.Visible = false;
            lblErrorPassword.Visible = false;
            lblError.Visible = false;

            string registro = null;

            if (user.Trim().Equals(""))
            {
                lblErrorUser.Visible = true;
                error = true;
            }

            if (password.Trim().Equals(""))
            {
                lblErrorPassword.Visible = true;
                error = true;
            }

            if (!error)
            {
                registro = registroController.login(user, password);
            }

            switch (registro)
            {
                case "direccion":
                    break;
                case "administrativo":
                    break;
                case "administrador":
                    break;
                case "personalsanitario":
                    break;
                case "":
                    lblError.Visible = true;
                    break;
            }
        }
    }
}
