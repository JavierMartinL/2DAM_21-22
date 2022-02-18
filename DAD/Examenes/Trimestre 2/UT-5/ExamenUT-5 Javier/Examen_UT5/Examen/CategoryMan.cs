using System;
using System.Collections;
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
    /// <summary>
    /// Vista de las categorias de Man
    /// </summary>
    public partial class CategoryMan : Form
    {
        ControllerCategoryMan ccm = null;

        /// <summary>
        /// Constructor que inicializa la vista, el controlador de las categoria Man y carga las categorias
        /// </summary>
        public CategoryMan()
        {
            InitializeComponent();
            ccm = new ControllerCategoryMan();
            obtenirCategoryMan("");

        }


        /// <summary>
        /// Método que recoge todas las categorias o en funcion del nombre introducido de la base de datos.
        /// </summary>
        /// <param name="cat">Nombre de la categoria a filtrar</param>
        private void obtenirCategoryMan(String cat)
        {
            ArrayList categoryman = new ArrayList();
            categoryman = ccm.getCategoryMan(cat);
            if (categoryman == null)
            {
                MessageBox.Show("No ha sido posible la connexión a la base de datos", "Error Interno", MessageBoxButtons.OK, MessageBoxIcon.Error);
                categoryman = new ArrayList();
            }
            else
            {
                dataGridView1.DataSource = categoryman;
            }
        }

        /// <summary>
        /// Método que controla el evento para mostrar los datos de un producto seleccionado de la tabla
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button2_Click(object sender, EventArgs e)
        {


            if (dataGridView1.CurrentRow != null) {
                String msg = "ID: " + dataGridView1.CurrentRow.Cells[0].Value + "\n" +
                "Name: " + dataGridView1.CurrentRow.Cells[1].Value + "\n" +
                "Category: " + dataGridView1.CurrentRow.Cells[2].Value + "\n" +
                "Description: " + dataGridView1.CurrentRow.Cells[3].Value + "\n" +
                "Price: " + dataGridView1.CurrentRow.Cells[4].Value + "\n" +
                "Quantity: " + dataGridView1.CurrentRow.Cells[5].Value + "\n";
                MessageBox.Show(msg, "Info", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            obtenirCategoryMan("");

        }

        /// <summary>
        /// Método que controla el evento que filtra las categorias hijas relacionadas con los productos
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button3_Click(object sender, EventArgs e)
        {
            Object itemselected = listBox1.SelectedItem;

            if (itemselected != null) {
                if (itemselected.ToString().Equals("All"))
                {
                    obtenirCategoryMan("");
                }
                else {
                    obtenirCategoryMan(itemselected.ToString());
                }
            }
        }

        /// <summary>
        /// Método controla el evento que recoge un producto seleccionado de la tabla 
        /// para agregarle una cantidad
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void button1_Click(object sender, EventArgs e)
        {
            if (dataGridView1.CurrentRow != null)
            {
                Model.CategoryMan cm = new Model.CategoryMan();

                cm.Id = int.Parse(dataGridView1.CurrentRow.Cells[0].Value.ToString());
                cm.Name = dataGridView1.CurrentRow.Cells[1].Value.ToString();
                cm.Category =dataGridView1.CurrentRow.Cells[2].Value.ToString();
                cm.Description = dataGridView1.CurrentRow.Cells[3].Value.ToString();
                cm.Price = double.Parse(dataGridView1.CurrentRow.Cells[4].Value.ToString());
                cm.Quantity = int.Parse(dataGridView1.CurrentRow.Cells[5].Value.ToString());
                

                Add add = new Add(cm);
                if (add.ShowDialog() == DialogResult.OK)
                {
                    
                    obtenirCategoryMan("");
                }
            }
        }
    }
}
