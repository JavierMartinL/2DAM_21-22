using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.dao;
using Model.entities;

namespace Controller
{
    public class CategoriaController
    {
        private CategoriaDAO categoriaDAO;

        public CategoriaController()
        {
            categoriaDAO = new CategoriaDAO();
        }

        /*
         * Método que se encarga de enviar a la vista una lista de categorias
         * recogidas de la DDBB
         */
        public List<Categoria> cargarCategorias()
        {
            return categoriaDAO.findAll();
        }
    }
}
