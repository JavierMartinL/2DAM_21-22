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

        public DataTable recogerProductos()
        {
            return productoDAO.findAll();
        }

        public List<string> recogerCategorias()
        {
            return productoDAO.findCategorias();  
        }
    }
}
