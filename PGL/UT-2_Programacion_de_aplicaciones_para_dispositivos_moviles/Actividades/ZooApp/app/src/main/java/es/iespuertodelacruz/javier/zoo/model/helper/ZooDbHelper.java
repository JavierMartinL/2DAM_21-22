package es.iespuertodelacruz.javier.zoo.model.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.iespuertodelacruz.javier.zoo.model.contract.ZooContract;
import es.iespuertodelacruz.javier.zoo.vo.Zoo;

public class ZooDbHelper extends ComunDbHelper {

    public ZooDbHelper(Context context) {
        super(context);
    }

    /**
     * Metodo encargado en crear la tabla de la BBDD
     * @param sqLiteDatabase BBDD SqLite
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ZooContract.ZooEntry.TABLE_NAME + " (" +
                ZooContract.ZooEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ZooContract.ZooEntry.NOMBRE + " TEXT NOT NULL," +
                ZooContract.ZooEntry.CIUDAD + " TEXT NOT NULL," +
                ZooContract.ZooEntry.PAIS + " TEXT NOT NULL," +
                ZooContract.ZooEntry.TAMANIO + " INTEGER NOT NULL," +
                ZooContract.ZooEntry.PRESUPUESTO_ANUAL + " REAL NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ZooContract.ZooEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    /**
     * Metodo que almacena la informacion en la BBDD
     * @param zoo Zoo de la BBDD
     * @return identificador con el resultado en el proceso de almacenar en la BBDD
     */
    public long save(Zoo zoo) {
        return super.save(ZooContract.ZooEntry.TABLE_NAME, zoo.toContentValues());
    }

    /**
     * Metodo que devuelve todos los elementos de la BBDD
     * @return Lista con los elementos
     */
    public List<Zoo> getAll() {
        List<Zoo> zoos = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(ZooContract.ZooEntry.TABLE_NAME, null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                zoos = new ArrayList<>();
                do {
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.NOMBRE));
                    @SuppressLint("Range") String ciudad = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.CIUDAD));
                    @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.PAIS));
                    @SuppressLint("Range") int tamanio = cursor.getInt(cursor.getColumnIndex(ZooContract.ZooEntry.TAMANIO));
                    @SuppressLint("Range") Double presupuestoAnual = cursor.getDouble(cursor.getColumnIndex(ZooContract.ZooEntry.PRESUPUESTO_ANUAL));
                    zoos.add(new Zoo(nombre, ciudad, pais, tamanio, presupuestoAnual));
                } while (cursor.moveToNext());
                return zoos;
            }
        } catch (Exception ex) { } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList();
    }

    public Zoo getById(String nombreBuscar) {
        Zoo zoo = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(ZooContract.ZooEntry.TABLE_NAME,
                    null,
                    ZooContract.ZooEntry.NOMBRE + " = ?",
                    new String[]{nombreBuscar},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.NOMBRE));
                @SuppressLint("Range") String ciudad = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.CIUDAD));
                @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.PAIS));
                @SuppressLint("Range") int tamanio = cursor.getInt(cursor.getColumnIndex(ZooContract.ZooEntry.TAMANIO));
                @SuppressLint("Range") Double presupuestoAnual = cursor.getDouble(cursor.getColumnIndex(ZooContract.ZooEntry.PRESUPUESTO_ANUAL));
                zoo = new Zoo(nombre, ciudad, pais, tamanio, presupuestoAnual);
            }
        } catch (Exception exception) { }finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return zoo;
    }

    public int delete(String nombre) {
        return super.delete(ZooContract.ZooEntry.TABLE_NAME,ZooContract.ZooEntry.NOMBRE + " = ?", new String[]{nombre});
    }

    public int update(Zoo zoo, String nombre) {
        return super.update(ZooContract.ZooEntry.TABLE_NAME, zoo.toContentValues(), ZooContract.ZooEntry.NOMBRE + " = ?", new String[]{nombre});
    }
}
