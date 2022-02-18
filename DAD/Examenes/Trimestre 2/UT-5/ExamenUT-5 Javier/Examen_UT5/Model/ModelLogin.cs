using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace Model
{
    public class ModelLogin
    {
        private static DBConnection dataSource;

        public ModelLogin()
        {
            dataSource = DBConnection.getInstance();
        }

        public Users obtenirUsuari(Users usuari)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;


            string sql = "SELECT role FROM users where id_staff=@id_staff and password=@password;";
            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);
                mysqlCmd.Parameters.Add(new MySqlParameter("@id_staff", usuari.Id_staff));
                mysqlCmd.Parameters.Add(new MySqlParameter("@password", usuari.Password));


                mysqlReader = mysqlCmd.ExecuteReader();
                String role = "sense";
                while (mysqlReader.Read())
                {
                    role = mysqlReader.GetString("role");
                }
                usuari.Role = role;
            }
            catch (Exception e)
            {
                usuari = null;
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mysqlReader != null) mysqlReader.Dispose();
                if (connection != null) connection.Close();
            }
            return usuari;
        }
    }
}
