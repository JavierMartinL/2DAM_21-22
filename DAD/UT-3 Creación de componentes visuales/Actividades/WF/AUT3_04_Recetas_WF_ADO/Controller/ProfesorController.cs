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

        /*
         * Método que recoge las categorías que existen en la base de datos y devuelve la lista de categorías existentes
         */
        public List<string> recogerCategorias()
        {
            return recetaDao.findCategorias();
        }

        /*
         * Método que busca pide las recetas según la categoría y devuelve un DataTable con los datos de la recetas
         */
        public DataTable buscarRecetasCategoria(string categoria)
        {
            // Pedir todas las recetas de la base de datos
            if (categoria.Equals("todas"))
                return recetaDao.findAll();
            // Pedir todas las recetas segun la categoria seleccionada
            else
                return recetaDao.findByCategria(categoria);
        }

        /*
         * Método que crea el objeto de Receta para poder guardarlo en la base de datos y devuelve un true si ha salido todo bien
         */
        public bool crearReceta(string nombre, string categoria, string tiempo, string ingredientes, string descripcion)
        {
            // Crear la receta
            Receta receta = new Receta(nombre, categoria, tiempo, ingredientes, descripcion);

            // guardarla en la base de datos
            return recetaDao.save(receta);
        }

        /*
         * Método para poder borrar una receta de la base de datos y devuelve un true si se ha borrado correctamente
         */
        public bool eliminarReceta(int value)
        {
            return recetaDao.delete(value);
        }
    }
}
