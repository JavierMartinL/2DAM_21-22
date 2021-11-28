using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Modelo.dao;

namespace Controller
{
    public class ProfesorController
    {
        private RecetaDAO recetaDao;

        public ProfesorController()
        {
            recetaDao = new RecetaDAO();
        }

        public List<string> recogerCategorias()
        {
            return recetaDao.findCategorias();
        }

        public DataTable buscarRecetasCategoria(string categoria)
        {
            if (categoria.Equals("todas"))
                return recetaDao.findAll();
            else
                return recetaDao.findByCategria(categoria);
        }

        public bool eliminarReceta(int value)
        {
            return recetaDao.delete(value);
        }
    }
}
