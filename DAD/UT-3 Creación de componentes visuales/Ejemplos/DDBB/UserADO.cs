using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace DataLayer
{
    public class UserADO
    {
        private static DBConnection dataSource;

        public UserADO() {
            dataSource = DBConnection.getInstance();
        }

        public int checkUser(User u) {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;

            //Unable to connect database.
            int profile = -2;

            string sql = "SELECT * FROM users where nickname='" + u.Nickname +"' and password='" + u.Password + "';";
            try
            {
                connection = dataSource.getConnection(); //Establecer la cadena de conexión.
                connection.Open(); //Open connection.

                //User does not exist.
                profile = -1;

                mysqlCmd = new MySqlCommand(sql, connection); //It makes the query
                mysqlReader = mysqlCmd.ExecuteReader(); //Executes query and get result.
                
                
                while (mysqlReader.Read()) {
                    //if profile = 0 is an admin user else is a basic user.
                    profile = mysqlReader.GetInt32("is_admin");
                }
            }
            catch (Exception e) { 
                
            } finally {
                if(mysqlCmd != null)mysqlCmd.Dispose();
                if(mysqlReader != null)mysqlReader.Dispose();
                if(connection != null) connection.Close();
            }
            return profile;
        }
    }
}
