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
using Model;
namespace View
{
    /// <summary>
    /// Vista del login
    /// </summary>
    public partial class Login : Form
    {
        Users usuari;
        ControllerLogin cl = null;

        /// <summary>
        /// Constructor que inicializa la vista y el controlador de login
        /// </summary>
        public Login()
        {
            InitializeComponent();
            cl = new ControllerLogin();
        }

        /// <summary>
        /// Método que controla el evento del boton que realizar el login
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button1_Click(object sender, EventArgs e)
        {
            int estat = validar_Login(textBox1.Text, textBox2.Text);

            if (estat == 0)
            {
                textBox1.Text = "";
                textBox2.Text = "";
            }



        }

        /// <summary>
        /// Método que valida los datos introducidos por el usuario con los que recibe de la DDBB
        /// y devuelve un entero segun como se validen los datos
        /// </summary>
        /// <param name="text_user"></param>
        /// <param name="text_login"></param>
        /// <returns>Numero con el valor del login</returns>
        public int validar_Login(string text_user, string text_login)
        {
            int sortida=0;

            if (text_user.Length > 0 && text_login.Length > 0 && comprova(text_user)) {

                Users usr = cl.loginUser(int.Parse(text_user), text_login);

                if (usr == null)
                {
                    MessageBox.Show("No ha estat posible la connexio a la base de dades", "Error Intern", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    sortida = 0;
                }
                else
                {
                    String rol = usr.Role;
                    if (!rol.Equals("sense"))
                    {

                        usuari = usr;
                        Categories cat = new Categories();
                        if(cat.ShowDialog() == DialogResult.OK)
                        {
                            sortida = 0;
                        }
                    }
                    else if(rol.Equals("sense"))
                    {
                        MessageBox.Show("Usuari o contrasenya incorrectes, torna a provar-ho", "Credencials incorrectes", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        sortida = 0;
                    }
                   
                }
            }
            else
            {
                MessageBox.Show("Has d'omplir els camps i han de tenir el format correcte, torna a provar-ho", "Credencials incorrectes", MessageBoxButtons.OK, MessageBoxIcon.Error);
                sortida = 1;
            }
            return sortida;

        }

        /// <summary>
        /// Método que comprueba que el numero de staff introducido es un numero
        /// </summary>
        /// <param name="text">Valor del staff</param>
        /// <returns>TRUE si es un numero valido, FALSE si falla al convertirlo</returns>
        private bool comprova(string text)
        {
            bool flag = true;
            try
            {
                int convert = Convert.ToInt32(text);
                

            }catch(Exception error)
            {
                flag = false;
            }
            return flag;
        }

        /// <summary>
        /// Getter y Setter de Usuario
        /// </summary>
        public Users Users
        {
            get
            {
                return usuari;
            }

            set
            {
                usuari = value;
            }
        }

        /// <summary>
        /// Método que controla el botón encargado de mostrar la Ayuda
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button2_Click(object sender, EventArgs e)
        {
            Help.ShowHelp(this, "Documentacion.chm");
        }
    }
}
