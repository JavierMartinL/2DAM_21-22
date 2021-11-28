using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Modelo.dao;
using Modelo.entities;

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

        public bool crearReceta(string nombre, string categoria, string tiempo, string ingredientes, string descripcion)
        {
            Receta receta = new Receta(nombre, categoria, tiempo, ingredientes, descripcion);

            return recetaDao.save(receta);
        }

        public bool eliminarReceta(int value)
        {
            return recetaDao.delete(value);
        }
    }
}
