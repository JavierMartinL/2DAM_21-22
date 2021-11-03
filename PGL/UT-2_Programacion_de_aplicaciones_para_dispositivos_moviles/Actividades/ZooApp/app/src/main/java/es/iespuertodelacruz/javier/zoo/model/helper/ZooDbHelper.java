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

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ZooContract.ZooEntry.TABLE_NAME + " (" +
                ZooContract.ZooEntry.NOMBRE + " TEXT NOT NULL," +
                ZooContract.ZooEntry.CIUDAD + " TEXT NOT NULL," +
                ZooContract.ZooEntry.PAIS + " TEXT NOT NULL," +
                ZooContract.ZooEntry.TAMANIO + " INTEGER NOT NULL," +
                ZooContract.ZooEntry.PRESUPUESTO_ANUAL + " REAL NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }

    public long save(Zoo zoo) {
        return super.save(ZooContract.ZooEntry.TABLE_NAME, zoo.toContentValues());
    }

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

}
