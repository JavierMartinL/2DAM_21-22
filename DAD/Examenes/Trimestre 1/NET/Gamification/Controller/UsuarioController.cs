using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model;
using Model.dao;

namespace Controller
{
    public class UsuarioController
    {
        private UsuarioDAO usuarioDAO;

        public UsuarioController()
        {
            usuarioDAO = new UsuarioDAO();
        }

        /*
         * Método que muestra los usuarios segun el rol seleccionado
         */
        public DataTable mostrarUsuariosRoles(string rol)
        {
            // Pedir todas los usuarios de la base de datos
            if (rol.Equals("todos"))
                return usuarioDAO.findAll();
            // Pedir todas los usuarios segun el rol
            else
                return usuarioDAO.findByRol(rol);
        }

        public bool crearUsuario(string username, string password, string rol)
        {
            Usuario usuario = new Usuario(username, password, rol, 1);

            return usuarioDAO.save(usuario);
        }
    }
}
