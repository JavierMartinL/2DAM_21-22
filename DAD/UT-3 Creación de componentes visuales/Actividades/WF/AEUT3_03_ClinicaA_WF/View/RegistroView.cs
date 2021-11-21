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
    public partial class RegistroView : Form
    {
        private RegistroController registroController;

        public RegistroView()
        {
            registroController = new RegistroController();
            InitializeComponent();
        }

        private void login(object sender, EventArgs e)
        {
            string user = txbUser.Text;
            string password = txbPassword.Text;

            bool error = false;
            lblErrorUser.Visible = false;
            lblErrorPassword.Visible = false;
            lblError.Visible = false;           

            string rol = null;

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
                rol = registroController.login(user, password);
            }

            switch (rol)
            {
                case "direccion":
                    mensajeConstruccion(user);
                    break;
                case "administrativo":
                    AdministrativoView administrativoView = new AdministrativoView();
                    Hide();
                    administrativoView.ShowDialog();
                    break;
                case "administrador":
                    mensajeConstruccion(user);
                    break;
                case "personalsanitario":
                    PersonalView personalView = new PersonalView();
                    Hide();
                    personalView.ShowDialog();
                    break;
                case "":
                    lblError.Visible = true;
                    break;
            }
        }

        private void mensajeConstruccion(string user)
        {
            string mensaje = "Bienvenido " + user + 
                " \nTe has registrado correctamente " +
                "\n\nLo lamentamos, esta sección está en construcción";
            const string titulo = "Construcción";

            var result = MessageBox.Show(mensaje, titulo, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);

            if (result == DialogResult.OK)
            {
                Application.Exit();
            }
        }
    }
}
