using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ctlProductDetailLib
{
    public partial class ctlProductDetail : UserControl
    {
        private string id;
        private string nombre;
        private string categoria;
        private string cantidad;

        public ctlProductDetail()
        {
            InitializeComponent();
        }

        public string Id { get => lblIdValue.Text; set => lblIdValue.Text = value; }

        public string Nombre { get => lblNameValue.Text; set => lblNameValue.Text = value; }

        public string Categoria { get => lblCategoryValue.Text; set => lblCategoryValue.Text = value; }

        public string Cantidad { get => lblQuantityValue.Text; set => lblQuantityValue.Text = value; }
    }
}
