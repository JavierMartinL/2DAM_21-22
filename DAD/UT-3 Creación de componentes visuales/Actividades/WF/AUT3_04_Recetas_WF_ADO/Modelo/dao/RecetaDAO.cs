using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Data;
using MySql.Data.MySqlClient;
using Modelo.entities;

namespace Modelo.dao
{
    public class RecetaDAO
    {
        private static DBConnection dataSource;

        public RecetaDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        /*
         * Método que recoge todas la recetas de la base de datos y devuelve en un DataTable
         */
        public DataTable findAll()
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataAdapter mysqlDAdapter = null;
            DataTable recetas = null;
            string sql = "SELECT id, name, time, ingredients, description FROM recipes;";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                recetas = new DataTable();
                mysqlDAdapter = new MySqlDataAdapter(mysqlCmd);
                mysqlDAdapter.Fill(recetas);
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

            return recetas;
        }

        /*
         * Método que recoge todas la recetas de una categoría de la base de datos y devuelve en un DataTable
         */
        public DataTable findByCategria(string categoria)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataAdapter mysqlDAdapter = null;
            DataTable recetas = null;
            string sql = "SELECT id, name, time, ingredients, description FROM recipes WHERE category = '" + categoria + "';";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                recetas = new DataTable();
                mysqlDAdapter = new MySqlDataAdapter(mysqlCmd);
                mysqlDAdapter.Fill(recetas);
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

            return recetas;
        }

        /*
         * Método que recoge las categorías que existen en la base de datos y devuelve una Lista de string
         */
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

        /*
         * Método que guarda una receta en la base de datos y devuelve un bool en función de cómo ha ido el guardado
         */
        public bool save(Receta receta)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            bool saveOk = false;
            string sql = "INSERT INTO recipes (name, category, time, ingredients, description) VALUES (" +
                "'" + receta.Nombre + "', " +
                "'" + receta.Categoria + "', " +
                "'" + receta.Tiempo + "', " +
                "'" + receta.Ingredientes + "', " +
                "'" + receta.Descripcion + "'" +
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

        /*
         * Método que elimina una receta mediante su id de la base de datos y devuelve un bool en función de cómo ha ido la eliminación
         */
        public bool delete(int id)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            bool deleteOk = false;
            string sql = "DELETE FROM recipes WHERE id = " + id + ";";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                deleteOk = mysqlCmd.ExecuteNonQuery() > 0;
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

            return deleteOk;
        }

    }
}
