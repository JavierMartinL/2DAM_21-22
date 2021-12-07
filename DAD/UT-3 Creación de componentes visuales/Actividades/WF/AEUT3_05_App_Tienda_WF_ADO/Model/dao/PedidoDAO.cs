using Model.entities;
using Model.utils;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.dao
{
    public class PedidoDAO
    {
        private static DBConnection dataSource;

        public PedidoDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        /*
         * Método que inserta un Pedido en la DDBB
         */
        public bool save(Pedido pedido)
        {
            // Evita que se pierdan valores al introducir un double en la DDBB
            System.Threading.Thread.CurrentThread.CurrentCulture = new System.Globalization.CultureInfo("en-US");
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            bool saveOk = false;
            string sql = "INSERT INTO basket (id, name, total) VALUES (" +
                pedido.Id + ", '" + pedido.Nombre + "', '" + pedido.Total + "');";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                saveOk = mysqlCmd.ExecuteNonQuery() > 0;
            }
            catch (Exception ex)
            {
                Console.WriteLine("ERROR!: " + ex.ToString());
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (connection != null) connection.Close();
            }

            return saveOk;
        }
    }
}
