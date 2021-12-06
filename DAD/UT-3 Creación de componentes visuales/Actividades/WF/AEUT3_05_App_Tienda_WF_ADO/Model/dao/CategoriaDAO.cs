using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.entities;
using Model.utils;
using MySql.Data.MySqlClient;

namespace Model.dao
{
    public class CategoriaDAO
    {
        private static DBConnection dataSource;

        public CategoriaDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        /*
         * Método que buscar todas las categorias de la DDBB
         */
        public List<Categoria> findAll()
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;
            List<Categoria> categorias = null;
            string sql = "SELECT * FROM categories;";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                mysqlReader = mysqlCmd.ExecuteReader();
                categorias = new List<Categoria>();

                while (mysqlReader.Read())
                {
                    int idCategoria = Convert.ToInt32(mysqlReader["id_category"]);
                    string nombre = mysqlReader["description"].ToString();

                    categorias.Add(new Categoria(idCategoria, nombre));
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

            return categorias;
        }
    }
}
