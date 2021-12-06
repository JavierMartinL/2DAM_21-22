using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.dao;

namespace Controller
{
    public class ProductCategoryController
    {
        private ProductoDAO productoDAO;

        public ProductCategoryController()
        {
            productoDAO = new ProductoDAO();
        }

        /*
         * Método que envia a la vista un DataTable con los productos segun la seleccion de categoría
         */
        public DataTable recogerProductos(string categoria)
        {
            // Todas los productos
            if (categoria.Equals("All"))
            {
                return productoDAO.findAll();
            }
            // Productos de la categoría seleccionada
            else
            {
                return productoDAO.findByCategoria(categoria);
            }
        }

        /*
         * Método que envia a la vista todas las categorías
         */
        public List<string> recogerCategorias()
        {
            return productoDAO.findCategorias();  
        }
    }
}
