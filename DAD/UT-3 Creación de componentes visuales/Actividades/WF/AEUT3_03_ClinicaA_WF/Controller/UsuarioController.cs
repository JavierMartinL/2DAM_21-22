using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model;
using View;

namespace Controller
{
    public class UsuarioController
    {
        Usuario usu;
        Registro view;

        public UsuarioController()
        {
            this.usu = new Model.Usuario("Javier", "1q2w3e4r", "TUPU"); ;
            this.view = new Registro();

            string a = view.txbUser.Text;
            Registro.login();
        }

    }
}
