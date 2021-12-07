using Model.entities;
using Model.utils;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model.dao
{
    public class ProductoDAO
    {
        private static DBConnection dataSource;

        public ProductoDAO()
        {
            dataSource = DBConnection.getInstance();
        }

        /*
         * Método que recoge todos los productos de la base de datos y devuelve en un DataTable
         */
        public DataTable findAll()
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataAdapter mysqlDAdapter = null;
            DataTable productos = null;
            string sql = "SELECT * FROM catman;";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                productos = new DataTable();
                mysqlDAdapter = new MySqlDataAdapter(mysqlCmd);
                mysqlDAdapter.Fill(productos);
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

            return productos;
        }

        /*
         * Método que busca un Producto segun el id
         */
        public Producto findById(int idProducto)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;
            Producto producto = null;
            string sql = "SELECT * FROM catman WHERE id = " + idProducto + ";";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                mysqlReader = mysqlCmd.ExecuteReader();

                while (mysqlReader.Read())
                {
                    int id = int.Parse(mysqlReader["id"].ToString());
                    string nombre = mysqlReader["name"].ToString();
                    string categoria = mysqlReader["category"].ToString();
                    string descripcion = mysqlReader["description"].ToString();
                    double price = double.Parse(mysqlReader["price"].ToString());
                    int cantidad = int.Parse(mysqlReader["quantity"].ToString());
                    
                    producto = new Producto(id, nombre, categoria, descripcion, price, cantidad);
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

            return producto;
        }

        /*
         * Método que recoge todos los productos de la base de datos segun la categoría seleccionada y devuelve en un DataTable
         */
        public DataTable findByCategoria(string categoria)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataAdapter mysqlDAdapter = null;
            DataTable productos = null;
            string sql = "SELECT * FROM catman WHERE category = '" + categoria + "';";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                productos = new DataTable();
                mysqlDAdapter = new MySqlDataAdapter(mysqlCmd);
                mysqlDAdapter.Fill(productos);
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

            return productos;
        }

        /*
         * Método que buscar las todas las categorias de MAN
         */
        public List<string> findCategorias()
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            MySqlDataReader mysqlReader = null;
            List<string> categorias = null;
            string sql = "SELECT DISTINCT(category) FROM catman;";

            try
            {
                connection = dataSource.getConnection();
                connection.Open();

                mysqlCmd = new MySqlCommand(sql, connection);

                mysqlReader = mysqlCmd.ExecuteReader();

                categorias = new List<string>();

                while (mysqlReader.Read())
                {
                    categorias.Add(mysqlReader["category"].ToString());
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

            return categorias;
        }

        /*
         * Método que actualiza un Producto
         */
        public bool UpdateQuantity(Producto producto)
        {
            MySqlConnection connection = null;
            MySqlCommand mysqlCmd = null;
            bool saveOk = false;
            string sql = "UPDATE catman SET quantity = " + producto.Cantidad + " " +
                "WHERE id = " + producto.Id + ";";

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
