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
using Model.entities;

namespace View
{
    public partial class CategoriaView : Form
    {
        private CategoriaController categoriaController;

        public CategoriaView()
        {
            categoriaController = new CategoriaController();
            InitializeComponent();

            // Cargar las Categorias 
            cargarCategorias();
        }

        /*
         * Método que pide las categorias a la DDBB y las muestra en pantalla
         */
        public void cargarCategorias()
        {
            // Recoger todas las categorias
            List<Categoria> categorias = categoriaController.cargarCategorias();

            // Crear un boton para cada categoria
            for(int i = 0; i < categorias.Count(); i++) 
            {
                // Crear boton
                Button button = new Button();

                // Agregar propiedades
                button.Name = "categoria_" + categorias[i].Id;
                button.Text = categorias[i].Nombre;
                button.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
                button.Margin = new Padding(4, 3, 4, 3);
                button.BackColor = Color.Black;
                button.ForeColor = Color.White;
                button.Location = new Point(30, 30 + i * 60);
                button.Size = new Size(125, 54);

                // Agregar Accion
                button.Click += new System.EventHandler(this.mostrarCategoria);

                // Mostrarlo en pantalla
                Controls.Add(button);
            }
        }

        /*
         * Método para reconocer que boton ha sido pulsado
         */
        private void mostrarCategoria(object sender, EventArgs e)
        {
            // Recoger el boton
            Button button = (Button) sender;
            // Capturar el id de la categoria
            int idCategoria = int.Parse(button.Name.Split('_')[1]);

            // Si la cartegoria es MAN mostrar el siguiente formulario
            if (idCategoria == 2)
            {
                // Crear el nuevo formulario
                ProductCategoryView manView = new ProductCategoryView();
                // Ocultar el actual
                this.Hide();
                // Mostrar el formulario
                manView.ShowDialog();
            } else
            {
                // informar al usuario que las demas categorias no están disponibles
                MessageBox.Show(
                    "La categoría \"" + button.Text  + "\" no se encuentra disponible actualmente",
                    "Categoría",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Information
                );
            }
        }
    }
}
