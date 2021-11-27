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

            string user = txbUser.Text;
            string password = txbPassword.Text;

            if (user.Equals(""))
            {
                error = true;
            }

            if (password.Equals(""))
            {
                error = true;
            }

            if (!error)
            {
                registroController.login(user, password);
            }
        }
    }
}
