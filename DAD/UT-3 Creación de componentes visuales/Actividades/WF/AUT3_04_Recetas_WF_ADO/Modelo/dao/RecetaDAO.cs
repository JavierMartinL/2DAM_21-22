using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Data;
using MySql.Data.MySqlClient;

namespace Modelo.dao
{
    public class RecetaDAO
    {
        private static DBConnection dataSource;

        public RecetaDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        public List<string> findCategorias()
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mySqlReader = null;
            List<string> categorias = new List<string>();
            string sql = "SELECT DISTINCT category FROM recipes;";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                mySqlReader = mysqlCmd.ExecuteReader();

                while (mySqlReader.Read())
                {
                    string categoria = mySqlReader["category"].ToString();

                    categorias.Add(categoria);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("ERROR!: " + ex.ToString());
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mySqlReader != null) mySqlReader.Dispose();
                if (connection != null) connection.Close();
            }

            return categorias;
        }
    }
}
