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
using Model;
namespace View
{
    public partial class Add : Form
    {
        ControllerBasket cb = null;
        ControllerCategoryMan ccm = null;
        Model.CategoryMan cm;
        public Add(Model.CategoryMan cm)
        {
            InitializeComponent();
            cb = new ControllerBasket();
            ccm = new ControllerCategoryMan();
            this.cm = cm;
            textBox2.Text = cm.Id.ToString();
        }


        private void button1_Click(object sender, EventArgs e)
        {

            string new_quantity = textBox1.Text.ToString();
            int result = add_new_quantity_to_basket(new_quantity);
            if (result == 0) MessageBox.Show("Compra apuntada!", "Compra", MessageBoxButtons.OK, MessageBoxIcon.Information);
            else if (result == 1) MessageBox.Show("Error al realizar la compra", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else if (result == 2) MessageBox.Show("No tenemos tantas unidades", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);

        }

        private int add_new_quantity_to_basket(string new_quantity)
        {
            int salida = 0;
            // Nodo 1
            if (new_quantity.Length > 0)
            {
                // Nodo 2
                if (int.Parse(new_quantity) <= cm.Quantity)
                {
                    // Nodo 3
                    Basket b = new Basket(cm.Id, cm.Name, int.Parse(new_quantity) * cm.Price);
                    if (cb.addToBasket(b))
                    {
                        ccm.updateQuantity(new Model.CategoryMan(cm.Id, cm.Quantity - int.Parse(new_quantity)));
                        salida = 0;
                    }
                    // Nodo 4
                    else
                    {

                        salida = 1;
                    }
                }
                // Nodo 5
                else
                {
                    salida = 2;
                }

            }
            // nodo F
            return salida;
        }
    }
}
