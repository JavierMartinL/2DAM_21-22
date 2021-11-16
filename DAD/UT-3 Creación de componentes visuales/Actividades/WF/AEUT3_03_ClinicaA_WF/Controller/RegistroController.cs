using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using View;

namespace Controller
{
    class RegistroController
    {
        RegistroView view;
        public RegistroController()
        {
            this.view = new RegistroView();
            view.Show();
        }

        private void login(object sender, EventArgs e)
        {
            Console.WriteLine(view.txbUser.Text);
        }
    }
}
