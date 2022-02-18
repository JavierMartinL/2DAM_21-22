using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using System.Collections;

namespace Model
{
    public class ModelBasket
    {
        private static DBConnection dataSource;

        public ModelBasket()
        {
            dataSource = DBConnection.getInstance();
        }

        public bool addToBasket(Basket b)
        {
            bool flag = false;
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;
            string sql = "INSERT INTO basket (id_catman, name, total) VALUES(@id, @name, @total);";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);
                mysqlCmd.Parameters.Add(new MySqlParameter("@id", b.Id));
                mysqlCmd.Parameters.Add(new MySqlParameter("@name", b.Name));
                mysqlCmd.Parameters.Add(new MySqlParameter("@total", b.Total));


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
