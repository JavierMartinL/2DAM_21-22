using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model.utils;
using MySql.Data.MySqlClient;

namespace Model.dao
{
    public class UsuarioDAO
    {
        private static DBConnection dataSource;

        public UsuarioDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        /*
         * Método que recoge todo los usuarios de la base de datos
         */
        public DataTable findAll()
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataAdapter mysqlDAdapter = null;
            DataTable usuarios = null;
            string sql = "SELECT username, role, active FROM users;";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                usuarios = new DataTable();
                mysqlDAdapter = new MySqlDataAdapter(mysqlCmd);
                mysqlDAdapter.Fill(usuarios);
            }
            catch (Exception ex)
            {
                Console.WriteLine("ERROR!: " + ex.ToString());
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mysqlDAdapter != null) mysqlDAdapter.Dispose();
                if (connection != null) connection.Close();
            }

            return usuarios;
        }

        /*
         * Método que recoge todo los usuarios de la base de datos segun el rol
         */
        public DataTable findByRol(string rol)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataAdapter mysqlDAdapter = null;
            DataTable usuarios = null;
            string sql = "SELECT username, role, active FROM users WHERE role = '" + rol + "';";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                usuarios = new DataTable();
                mysqlDAdapter = new MySqlDataAdapter(mysqlCmd);
                mysqlDAdapter.Fill(usuarios);
            }
            catch (Exception ex)
            {
                Console.WriteLine("ERROR!: " + ex.ToString());
            }
            finally
            {
                if (mysqlCmd != null) mysqlCmd.Dispose();
                if (mysqlDAdapter != null) mysqlDAdapter.Dispose();
                if (connection != null) connection.Close();
            }

            return usuarios;
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
                    // Recoger los datos de la consulta
                    string username = mysqlReader["username"].ToString();
                    string password = mysqlReader["password"].ToString();
                    string role = mysqlReader["role"].ToString();
                    int active = Convert.ToInt32(mysqlReader["active"]);

                    // Crear un usuario con los datos
                    usuario = new Usuario(username, password, role, active);
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

        /*
         * Método que guarda una receta en la base de datos y devuelve un bool en función de cómo ha ido el guardado
         */
        public bool save(Usuario usuario)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            bool saveOk = false;
            string sql = "INSERT INTO users (username, password, role, active) VALUES (" +
                "'" + usuario.Username + "', " +
                "'" + usuario.Password + "', " +
                "'" + usuario.Role + "', " +
                "'" + usuario.Active + "', " +
                ");";

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
