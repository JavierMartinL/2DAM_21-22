package es.iespuertodelacruz.javier.zoo.model.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import es.iespuertodelacruz.javier.zoo.model.contract.AnimalContract;
import es.iespuertodelacruz.javier.zoo.vo.Animal;

public class AnimalDbHelper extends ComunDbHelper {

    public AnimalDbHelper(Context context) {
        super(context);
    }

    /**
     * Metodo encargado en crear la tabla de la BBDD
     *
     * @param sqLiteDatabase BBDD SqLite
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + AnimalContract.AnimalEntry.TABLE_NAME + " (" +
                AnimalContract.AnimalEntry.IDENTIFICADOR + " INTEGER PRIMARY KEY, " +
                AnimalContract.AnimalEntry.ESPECIE + " TEXT NOT NULL," +
                AnimalContract.AnimalEntry.SEXO + " TEXT NOT NULL," +
                AnimalContract.AnimalEntry.NACIMIENTO + " TEXT NOT NULL," +
                AnimalContract.AnimalEntry.PAIS + " TEXT NOT NULL," +
                AnimalContract.AnimalEntry.CONTINENTE + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    /**
     * Metodo que almacena la informacion en la BBDD
     *
     * @param animal Animal de la BBDD
     * @return identificador con el resultado en el proceso de almacenar en la BBDD
     */
    public long save(Animal animal) {
        return super.save(AnimalContract.AnimalEntry.TABLE_NAME, animal.toContentValues());
    }

    /**
     * Metodo que devuelve todos los elementos de la BBDD
     *
     * @return Lista con los elementos
     */
    public List<Animal> getAll() {
        List<Animal> animales = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(AnimalContract.AnimalEntry.TABLE_NAME, null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                animales = new ArrayList<>();
                do {
                    @SuppressLint("Range") int identificador = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.IDENTIFICADOR));
                    @SuppressLint("Range") String especie = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.ESPECIE));
                    @SuppressLint("Range") String sexo = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.SEXO));
                    @SuppressLint("Range") String nacimiento = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.NACIMIENTO));
                    @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.PAIS));
                    @SuppressLint("Range") String continente = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CONTINENTE));
                    animales.add(new Animal(identificador, especie, sexo, nacimiento, pais, continente));
                } while (cursor.moveToNext());
                return animales;
            }
        } catch (Exception ex) {
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList();
    }

    public Animal getById(String id) {
        Animal animal = null;
        Cursor cursor = null;

        try {
            cursor = super.getAll(AnimalContract.AnimalEntry.TABLE_NAME,
                    null,
                    AnimalContract.AnimalEntry.IDENTIFICADOR + " = ?",
                    new String[]{id},
                    null,
                    null,
                    null);

            if (cursor.moveToFirst()) {
                @SuppressLint("Range") int identificador = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.IDENTIFICADOR));
                @SuppressLint("Range") String especie = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.ESPECIE));
                @SuppressLint("Range") String sexo = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.SEXO));
                @SuppressLint("Range") String nacimiento = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.NACIMIENTO));
                @SuppressLint("Range") String pais = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.PAIS));
                @SuppressLint("Range") String continente = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CONTINENTE));
                animal = new Animal(identificador, especie, sexo, nacimiento, pais, continente);
            }
        } catch (Exception exception) {
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        return animal;
    }

    public int delete(String id) {
        return super.delete(AnimalContract.AnimalEntry.TABLE_NAME, AnimalContract.AnimalEntry.IDENTIFICADOR + " = ?", new String[]{id});
    }

    public int update(Animal animal, String id) {
        return super.update(AnimalContract.AnimalEntry.TABLE_NAME, animal.toContentValues(), AnimalContract.AnimalEntry.IDENTIFICADOR + " = ?", new String[]{id});
    }
}
