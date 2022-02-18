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
using System.Collections;
using Model;

namespace View
{
    /// <summary>
    /// Vista de las Categorias Principales
    /// </summary>
    public partial class Categories : Form
    {
        ControllerCategories cc = null;

        /// <summary>
        /// Constructor que inicializa la vista, el controlador de las categorias y carga las categorias
        /// </summary>
        public Categories()
        {
            InitializeComponent();
            cc = new ControllerCategories();
            loadButtons();
        }

        /// <summary>
        /// Metodo que recoge las todas las categorias principales, crea un botón para cada una
        /// de ellas y los agrega a la vista
        /// </summary>
        public void loadButtons() {
            ArrayList list = cc.getCategories();

            if (list != null) {
                int y = 45;
                foreach (Model.Categories item in list) {
                    Button bt = new Button();
                    bt.BackColor = System.Drawing.Color.Black;
                    bt.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
                    bt.ForeColor = System.Drawing.Color.White;
                    bt.Location = new System.Drawing.Point(12, y);
                    bt.Name = item.Description;
                    bt.Size = new System.Drawing.Size(172, 48);
                    bt.TabIndex = 0;
                    bt.Text = item.Description;
                    bt.UseVisualStyleBackColor = false;


                    if (item.Description.Equals("man")) {
                        bt.Click += new System.EventHandler(this.Man_Click);
                    }
                    else
                    {
                        bt.Click += new System.EventHandler(this.Others_Click);
                    }

                    Controls.Add(bt);

                    y += 55;
                }

            }
        }

        /// <summary>
        /// Método que controla el evento del botón de MAN para poder acceder a su vista
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Man_Click(object sender, EventArgs e)
        {
            CategoryMan cm = new CategoryMan();
            if (cm.ShowDialog() == DialogResult.OK)
            {
                Close();
            }
        }
        /// <summary>
        /// Método que controla el evento de todos botones y muestra una alerta (En construccion)
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Others_Click(object sender, EventArgs e)
        {
            MessageBox.Show("En construcción","Información",MessageBoxButtons.OK,MessageBoxIcon.Information); 
        }
            private void tancant(object sender, FormClosingEventArgs e)
        {
            DialogResult=DialogResult.OK;
        }
    }
}
