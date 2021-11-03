package es.iespuertodelacruz.javier.zoo.model.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.iespuertodelacruz.javier.zoo.model.contract.EspecieContract;
import es.iespuertodelacruz.javier.zoo.vo.Especie;

public class EspecieDbHelper extends ComunDbHelper {

    public EspecieDbHelper(Context context) {
        super(context);
    }

    /**
     * Metodo encargado en crear la tabla de la BBDD
     * @param sqLiteDatabase BBDD SqLite
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + EspecieContract.EspecieEntry.TABLE_NAME + " (" +
                EspecieContract.EspecieEntry.NOMBRE_VULGAR + " TEXT PRIMARY KEY NOT NULL," +
                EspecieContract.EspecieEntry.NOMBRE_CIENTIFICO + " TEXT NOT NULL," +
                EspecieContract.EspecieEntry.FAMILIA + " TEXT NOT NULL," +
                EspecieContract.EspecieEntry.PELIGRO_EXTINCION + " INTEGER NOT NULL," +
                "UNIQUE (" + EspecieContract.EspecieEntry.NOMBRE_VULGAR + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }

    /**
     * Metodo que almacena la informacion en la BBDD
     * @param especie especie de la BBDD
     * @return identificador con el resultado en el proceso de almacenar en la BBDD
     */
    public long save(Especie especie) {
        return super.save(EspecieContract.EspecieEntry.TABLE_NAME, especie.toContentValues());
    }

    /**
     * Metodo que devuelve todos los elementos de la BBDD
     * @return Lista con los elementos
     */
    public List<Especie> getAll() {
        List<Especie> especies = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(EspecieContract.EspecieEntry.TABLE_NAME, null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                especies = new ArrayList<>();
                do {
                    @SuppressLint("Range") String nombreVulgar = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRE_VULGAR));
                    @SuppressLint("Range") String nombreCientifico = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRE_VULGAR));
                    @SuppressLint("Range") String familia = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.FAMILIA));
                    @SuppressLint("Range") boolean peligroExtincion = cursor.getInt(cursor.getColumnIndex(EspecieContract.EspecieEntry.PELIGRO_EXTINCION)) == 1;
                    especies.add(new Especie(nombreVulgar, nombreCientifico, familia, peligroExtincion));
                } while (cursor.moveToNext());
                return especies;
            }
        } catch (Exception ex) { } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList();
    }

    public Especie getById(String nombreVulg) {
        Especie especie = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(EspecieContract.EspecieEntry.TABLE_NAME,
                    null,
                    EspecieContract.EspecieEntry.NOMBRE_VULGAR + " = ?",
                    new String[]{nombreVulg},
                    null,
                    null,
                    null);

            if(cursor.moveToFirst()){
                @SuppressLint("Range") String nombreVulgar = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRE_VULGAR));
                @SuppressLint("Range") String nombreCientifico = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.NOMBRE_VULGAR));
                @SuppressLint("Range") String familia = cursor.getString(cursor.getColumnIndex(EspecieContract.EspecieEntry.FAMILIA));
                @SuppressLint("Range") boolean peligroExtincion = cursor.getInt(cursor.getColumnIndex(EspecieContract.EspecieEntry.PELIGRO_EXTINCION)) == 1;
                especie = new Especie(nombreVulgar, nombreCientifico, familia, peligroExtincion);
            }
        } catch (Exception exception) { }finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return especie;
    }

    public int delete(String nombreVulg) {
        return super.delete(EspecieContract.EspecieEntry.TABLE_NAME,EspecieContract.EspecieEntry.NOMBRE_VULGAR + " = ?", new String[]{nombreVulg});
    }

    public int update(Especie especie, String nombreVulg) {
        return super.update(EspecieContract.EspecieEntry.TABLE_NAME, especie.toContentValues(), EspecieContract.EspecieEntry.NOMBRE_VULGAR + " = ?", new String[]{nombreVulg});
    }
}
