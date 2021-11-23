using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace DataLayer
{
    class DBConnection
    {
        private static readonly String HOST = "localhost";
        private static readonly String BD = "ebookshop";
        private static readonly String USER = "root";
        private static readonly String PASSWORD = "";
        private static MySqlConnection sqlCon;
        private static DBConnection instance = null;

        protected DBConnection()
        {

        }

        public static DBConnection getInstance() {
            if(instance == null) {
                instance = new DBConnection();
            }
            return instance;
        }

        public MySqlConnection getConnection() {
            return sqlCon = new MySqlConnection("Server=" + HOST + ";Database=" + BD + ";Uid=" + USER + ";Pwd=" + PASSWORD + ";");
        }
    }
}
