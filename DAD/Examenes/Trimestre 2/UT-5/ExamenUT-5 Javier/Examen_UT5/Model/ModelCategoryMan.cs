using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Collections;

namespace Model
{
    public class ModelCategoryMan
    {
        private static DBConnection dataSource;

        public ModelCategoryMan()
        {
            dataSource = DBConnection.getInstance();
        }

        public ArrayList getCategoryMan(String cat)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;
            
            string sql = "SELECT * FROM catman";
            sql += " where 1=1 ";
            if (cat.Length > 0)
            {
                sql += "and category = @category";
            }
            sql += ";";
            ArrayList list = new ArrayList();
            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                if (cat.Length > 0)
                {
                    mysqlCmd.Parameters.Add(new MySqlParameter("@category", cat));
                }

                 mysqlReader = mysqlCmd.ExecuteReader();
                
                while (mysqlReader.Read())
                {
                    list.Add(new CategoryMan(mysqlReader.GetInt32("id"), mysqlReader.GetString("name"), mysqlReader.GetString("category"), mysqlReader.GetString("description"), mysqlReader.GetDouble("price"), mysqlReader.GetInt32("quantity")));
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


        public bool updateQuantity(CategoryMan cm)
        {
            bool flag = false;
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;
            string sql = "UPDATE catman SET quantity =@quantity WHERE id=@id";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);
                mysqlCmd.Parameters.Add(new MySqlParameter("@id", cm.Id));
                mysqlCmd.Parameters.Add(new MySqlParameter("@quantity", cm.Quantity));


                if (mysqlCmd.ExecuteNonQuery() > 0) flag = true;
            }
            catch (Exception e)
            {
                flag = false;
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mysqlReader != null) mysqlReader.Dispose();
                if (connection != null) connection.Close();
            }
            return flag;
        }
    }
}
