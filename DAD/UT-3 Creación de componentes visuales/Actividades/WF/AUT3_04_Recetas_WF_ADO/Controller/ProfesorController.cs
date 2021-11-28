using System;
using System.Collections.Generic;
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
    }
}
