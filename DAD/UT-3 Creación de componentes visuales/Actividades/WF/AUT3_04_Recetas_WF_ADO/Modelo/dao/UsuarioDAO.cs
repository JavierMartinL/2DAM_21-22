﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Data;
using MySql.Data.MySqlClient;

namespace Modelo.dao
{
    public class UsuarioDAO
    {
        private static DBConnection dataSource;

        public UsuarioDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        /*
         * Método que buscar un Usuario según el nombre introducido y devuelve un usuario con todo los datos
         */
        public Usuario findByName(string nombre)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;
            Usuario usuario = null;
            string sql = "SELECT * FROM users WHERE username = '" + nombre + "';";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                mysqlReader = mysqlCmd.ExecuteReader();

                while (mysqlReader.Read())
                {
                    int id = Convert.ToInt32(mysqlReader["id"]);
                    string username = mysqlReader["username"].ToString();
                    string password = mysqlReader["password"].ToString();
                    string role = mysqlReader["role"].ToString();

                    usuario = new Usuario(id, username, password, role);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("ERROR!: " + ex.ToString());
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mysqlReader != null) mysqlReader.Dispose();
                if (connection != null) connection.Close();
            }

            return usuario;
        }
    }
}
