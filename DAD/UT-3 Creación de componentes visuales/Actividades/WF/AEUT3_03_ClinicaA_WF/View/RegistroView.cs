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
        public RegistroView()
        {
            InitializeComponent();
        }

        private void login(object sender, EventArgs e)
        {
            string user = txbUser.Text;
            string password = txbPassword.Text;

            Console.WriteLine(user);
            Console.WriteLine(password);
        }
    }
}
