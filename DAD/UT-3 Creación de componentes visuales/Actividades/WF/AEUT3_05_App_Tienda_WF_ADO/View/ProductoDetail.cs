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
    public partial class ProductoDetail : Form
    {
        private ProductCategoryController productCategoryController;

        public ProductoDetail(int idProducto)
        {
            productCategoryController = new ProductCategoryController();
            InitializeComponent();
            cargarDatos(productCategoryController.recogerProducto(idProducto));
        }

        /*
         * Método para cargar los datos del producto
         */
        private void cargarDatos(Producto producto)
        {
            ctlProductDetail.Id = producto.Id + "";
            ctlProductDetail.Nombre = producto.Nombre;
            ctlProductDetail.Categoria = producto.Categoria;
            ctlProductDetail.Cantidad = producto.Cantidad + "";
        }
    }
}
