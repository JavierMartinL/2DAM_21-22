using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Collections;

namespace Model
{
    public class ModelCategories
    {
        private static DBConnection dataSource;

        public ModelCategories()
        {
            dataSource = DBConnection.getInstance();
        }

        public ArrayList getCategories()
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;
            
            string sql = "SELECT * FROM categories;";
            ArrayList list = new ArrayList();
            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                mysqlReader = mysqlCmd.ExecuteReader();
                
                while (mysqlReader.Read())
                {
                    list.Add(new Categories(mysqlReader.GetInt32("id_category"), mysqlReader.GetString("description")));
                }
            }
            catch (Exception e)
            {
                list = null;
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mysqlReader != null) mysqlReader.Dispose();
                if (connection != null) connection.Close();
            }
            return list;
        }
    }
}
