using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.dao;
using Model.entities;

namespace Controller
{
    public class ProductCategoryController
    {
        private PedidoDAO pedidoDAO;
        private ProductoDAO productoDAO;

        public ProductCategoryController()
        {
            productoDAO = new ProductoDAO();
            pedidoDAO = new PedidoDAO();
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
         * Método para recoger los datos de un Producto segun su ID
         */
        public Producto recogerProducto(int idProducto)
        {
            return productoDAO.findById(idProducto);
        }

        /*
         * Método que envia a la vista todas las categorías
         */
        public List<string> recogerCategorias()
        {
            return productoDAO.findCategorias();  
        }

        /*
         * Método para realizar un pedido
         */
        public bool crearPedido(Producto producto, int cantidad)
        {
            // Comprobar que existe mas Stock que la cantidad del pedido
            if (cantidad <= producto.Cantidad)
            {
                // Restar la cantidad al Stock
                producto.Cantidad -= cantidad;
                // Actualizar el producto
                if (productoDAO.UpdateQuantity(producto))
                {
                    // Crear el pedido
                    return pedidoDAO.save(new Pedido(producto.Id, producto.Nombre, producto.Precio * cantidad));
                }
                // Error al Actualizar el Producto
                else
                {
                    return false;
                }
            }
            // Error al existir menos Stock que el pedido
            else
            {
                return false;
            }
        }
    }
}
