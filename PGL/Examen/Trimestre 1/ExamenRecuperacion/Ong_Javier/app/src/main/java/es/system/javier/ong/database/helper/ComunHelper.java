package es.system.javier.ong.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import es.system.javier.ong.database.contract.MascotaContract;

public class ComunHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Ong.db";
    public static final int DATABASE_VERSION = 1;

    public ComunHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Método que se encarga de realizar la creación de todas las tablas
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Crear la tabla de Mascotas
        sqLiteDatabase.execSQL(MascotaContract.SQL_CREATE_ENTRIES);
    }

    /**
     * Método que se encarga de actualizar todas las tablas al cambiar de version
     * @param sqLiteDatabase
     * @param i version anterior
     * @param i1 version a actualizar
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(MascotaContract.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    /**
     * Método que retorna un cursor con todos los elementos de la tabla
     * @param table nombre de la tabla
     * @return Cursor con el resultado
     */
    public Cursor search(String table) {
        return search(table, null, null, null, null, null, null);
    }

    /**
     * Funcion encargada de realizar una consulta sobre una tabla de la BBDD
     * @param table nombre de la tabla
     * @param projection Conjunto de columnas que deseamos obtener
     * @param selection Columnas de la clausula Where
     * @param selectionArgs Valores de las columnas de la clausula Where
     * @param sortOrder Odernacion que se desea
     * @return Cursor con el resultado
     */
    public Cursor search(String table, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return search(table, projection, selection, selectionArgs, null, null, sortOrder);
    }

    /**
     * Funcion encargada de realizar una consulta sobre una tabla de la BBDD
     * @param table nombre de la tabla
     * @param projection Conjunto de columnas que deseamos obtener
     * @param selection Columnas de la clausula Where
     * @param selectionArgs Valores de las columnas de la clausula Where
     * @param groupBy Agrupacion de resultados
     * @param having Clausula having
     * @param sortOrder Ordenacion que se desea
     * @return Cursor con el resultado
     */
    public Cursor search(String table, String[] projection, String selection, String[] selectionArgs,String groupBy, String having, String sortOrder) {
        Cursor cursor = getReadableDatabase().query(
                table,
                projection,
                selection,
                selectionArgs,
                groupBy,
                having,
                sortOrder
        );

        cursor.moveToFirst();

        return cursor;
    }

    /**
     * Método encargado de realizar la insercion sobre la ddbb
     * @param table nombre de la tabla
     * @param contentValues contenido del objeto
     * @return TRUE si se ha insertado
     */
    public boolean save (String table, ContentValues contentValues) {
        boolean resultado = false;

        long fila = getWritableDatabase().insert(table, null, contentValues);

        if (fila != -1) {
            resultado = true;
        }

        return resultado;
    }

    /**
     * Método encargado de realizar la actualizacion sobre la ddbb
     * @param table nombre de la tabla
     * @param contentValues contenido del objeto
     * @param selection filtro para identificar el elemento
     * @param selectionArgs argumentos para identificar
     * @return TRUE si se ha actualizado 1 o mas filas
     */
    public boolean update (String table,ContentValues contentValues, String selection, String[] selectionArgs) {
        boolean resultado = false;

        int filasAfectadas = getWritableDatabase().update(
                table,
                contentValues,
                selection,
                selectionArgs
        );

        if (filasAfectadas > 0) {
            resultado = true;
        }

        return resultado;
    }

    /**
     * Método encargado de realizar la eliminación sobre la ddbb
     * @param table nombre de la tabla
     * @param selection filtro para identificar el elemento
     * @param selectionArgs argumentos para identificar
     * @return TRUE si se ha eliminado 1 o mas filas
     */
    public boolean delete (String table, String selection, String[] selectionArgs) {
        boolean resultado = false;

        int filasAfectadas = getWritableDatabase().delete(
                table,
                selection,
                selectionArgs
        );

        if (filasAfectadas > 0) {
            resultado = true;
        }

        return resultado;
    }
}
