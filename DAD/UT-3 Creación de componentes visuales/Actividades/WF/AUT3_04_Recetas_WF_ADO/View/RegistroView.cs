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
            bool error = false;
            lblErrorUser.Visible = false;
            lblErrorPassword.Visible = false;
            lblError.Visible = false;

            string user = txbUser.Text;
            string password = txbPassword.Text;
            string rol = null;

            if (user.Equals("")) 
                error = lblErrorUser.Visible = true;
            if (password.Equals("")) 
                error = lblErrorPassword.Visible = true;

            if (!error) 
                rol = registroController.login(user, password);

            switch (rol)
            {
                case "":
                    lblError.Visible = true;
                    break;

                case "profesor":
                case "profesora":
                    ProfesorView profesorView = new ProfesorView();
                    this.Hide();
                    profesorView.ShowDialog();
                    Application.Exit();
                    break;

                case "alumno":
                case "alumna":

                    string mensaje = "Bienvenido \"" + user +
                        "\"\nTe has registrado correctamente " +
                        "\n\nLo lamentamos, esta sección está en construcción";
                    const string titulo = "Bienvenido";

                    MessageBox.Show(mensaje, titulo, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    Application.Exit();
                    break;
            }
        }
    }
}
