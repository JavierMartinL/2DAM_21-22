package es.system.javier.clinica.model.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.system.javier.clinica.model.contract.AnimalContract;
import es.system.javier.clinica.vo.Animal;

public class AnimalDbHelper extends SQLiteOpenHelper {

    // Version de la DDBB
    public static final int DATABASE_VERSION = 1;
    // Nombre de la DDBB
    public static final String DATABASE_NAME = "clinica.db";

    /**
     * Metodo encargado en crear la tabla de la BBDD
     *
     * @param context de la app
     */
    public AnimalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Metodo encargado en crear la tabla de la BBDD
     *
     * @param context de la app
     * @param table de la DDBB
     * @param factory conexion de la DDBB
     * @param tableVersion de la DDBB
     */
    public AnimalDbHelper(Context context, String table, SQLiteDatabase.CursorFactory factory, int tableVersion) {
        super(context, table, factory, tableVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Crear la tabla dentro de la base de datos
        sqLiteDatabase.execSQL("CREATE TABLE " + AnimalContract.AnimalEntry.TABLE_NAME + " (" +
                AnimalContract.AnimalEntry.IDENTIFICADOR + " INTEGER PRIMARY KEY, " +
                AnimalContract.AnimalEntry.NOMBRE + " TEXT NOT NULL," +
                AnimalContract.AnimalEntry.RAZA + " TEXT NOT NULL," +
                AnimalContract.AnimalEntry.EDAD + " INTEGER NOT NULL," +
                AnimalContract.AnimalEntry.CHIP + " TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Borrar la tabla de la DDBB
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + AnimalContract.AnimalEntry.TABLE_NAME);
        // Crear una nueva tabla
        onCreate(sqLiteDatabase);
    }

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockAnimal(sqLiteDatabase, new Animal(1, "Paco",
                "Perro", 10, "tfs324sd"));
        mockAnimal(sqLiteDatabase, new Animal(2, "Ruben",
                "Gato", 9, "tfq322sd"));
        mockAnimal(sqLiteDatabase, new Animal(3, "Toby",
                "Pero", 3, "tfew3553sd"));
        mockAnimal(sqLiteDatabase, new Animal(4, "Paco",
                "Perro", 10, "tfs324sd"));
        mockAnimal(sqLiteDatabase, new Animal(5, "Ruben",
                "Gato", 9, "tfq322sd"));
        mockAnimal(sqLiteDatabase, new Animal(6, "Toby",
                "Pero", 3, "tfew3553sd"));
        mockAnimal(sqLiteDatabase, new Animal(7, "Paco",
                "Perro", 10, "tfs324sd"));
        mockAnimal(sqLiteDatabase, new Animal(8, "Ruben",
                "Gato", 9, "tfq322sd"));
        mockAnimal(sqLiteDatabase, new Animal(9, "Toby",
                "Pero", 3, "tfew3553sd"));mockAnimal(sqLiteDatabase, new Animal(1, "Paco",
                "Perro", 10, "tfs324sd"));
        mockAnimal(sqLiteDatabase, new Animal(10, "Ruben",
                "Gato", 9, "tfq322sd"));
        mockAnimal(sqLiteDatabase, new Animal(11, "Toby",
                "Pero", 3, "tfew3553sd"));

    }

    public long mockAnimal(SQLiteDatabase db, Animal animal) {
        return db.insert(
                AnimalContract.AnimalEntry.TABLE_NAME,
                null,
                animal.toContentValues());
    }

    /**
     * Metodo que almacena la informacion en la BBDD
     *
     * @param animal Animal de la BBDD
     * @return identificador con el resultado en el proceso de almacenar en la BBDD
     */
    public long save(Animal animal) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(AnimalContract.AnimalEntry.TABLE_NAME, null, animal.toContentValues());
    }

    public Cursor getAll() {
        return getReadableDatabase()
                .query(
                        AnimalContract.AnimalEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }
    /**
     * Método que devuelve todos los elementos de la BBDD
     *
     * @return Lista con los elementos
     */
    /*
    public List<Animal> getAll() {
        // Lista de animales que vamos a devolver
        List<Animal> animales = null;
        Cursor cursor = null;

        try {
            // Recoger los valores de la DDBB
            cursor = getReadableDatabase().query(
                    AnimalContract.AnimalEntry.TABLE_NAME,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
                    );

            // Mover el cursor al principio
            if (cursor.moveToFirst()) {
                // Crear lista
                animales = new ArrayList<>();
                // Por cada iteracion crear un nuevo animal
                do {
                    // Recoger los valores
                    @SuppressLint("Range") int identificador = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.IDENTIFICADOR));
                    @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.NOMBRE));
                    @SuppressLint("Range") String raza = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.RAZA));
                    @SuppressLint("Range") int edad = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.EDAD));
                    @SuppressLint("Range") String chip = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CHIP));

                    // Crear animal y agregarlo a la lista
                    animales.add(new Animal(identificador, nombre, raza, edad, chip));
                } while (cursor.moveToNext());
                // Devolver la lista
                return animales;
            }
        } catch (Exception ex) {
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }

        return Collections.emptyList();
    }*/

    public Cursor getById(String id) {
        return getReadableDatabase().query(
                AnimalContract.AnimalEntry.TABLE_NAME,
                null,
                AnimalContract.AnimalEntry.IDENTIFICADOR + " = ?",
                new String[] {id},
                null,
                null,
                null
            );
    }
    /**
     * Método que devuelve un animal de la BBDD segun el identificador
     *
     * @param id identificador del animal
     * @return Si existe un objeto Animal y sino un null
     */
    /*public Animal getById(String id) {
        // Animal que vamos a devolver
        Animal animal = null;
        Cursor cursor = null;

        try {
            // Recoger los valores de la DDBB
            cursor  = getReadableDatabase().query(
                    AnimalContract.AnimalEntry.TABLE_NAME,
                    null,
                    AnimalContract.AnimalEntry.IDENTIFICADOR + " = ?",
                    new String[] {id},
                    null,
                    null,
                    null
                    );

            // Mover el cursor al principio
            if (cursor.moveToFirst()) {
                // Recoger los valores
                @SuppressLint("Range") int identificador = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.IDENTIFICADOR));
                @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.NOMBRE));
                @SuppressLint("Range") String raza = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.RAZA));
                @SuppressLint("Range") int edad = cursor.getInt(cursor.getColumnIndex(AnimalContract.AnimalEntry.EDAD));
                @SuppressLint("Range") String chip = cursor.getString(cursor.getColumnIndex(AnimalContract.AnimalEntry.CHIP));

                // Crear animal
                animal = new Animal(identificador, nombre, raza, edad, chip);
            }
        } catch (Exception exception) {
        } finally {
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
        // Devolver animal
        return animal;
    }*/

    /**
     * Método que elimina la informacion de un animal en la BBDD segun el identificador
     *
     * @param id identificador del animal que queremos eliminar
     * @return Un valor para comprobar que se ha borrado correctamente
     */
    public int delete(String id) {
        return getWritableDatabase().delete(
                AnimalContract.AnimalEntry.TABLE_NAME,
                AnimalContract.AnimalEntry.IDENTIFICADOR + " = ?",
                new String[]{id}
                );
    }

    /**
     * Método que modifica la informacion de un animal en la BBDD segun el identificador
     *
     * @param animal objeto con los nuevos datos del animal
     * @param id identificador del animal que queremos modificar
     * @return Un valor para comprobar que se ha modificado correctamente
     */
    public int update(Animal animal, String id) {
        return getWritableDatabase().update(
                AnimalContract.AnimalEntry.TABLE_NAME,
                animal.toContentValues(),
                AnimalContract.AnimalEntry.IDENTIFICADOR + " = ?",
                new String[]{id}
                );
    }
}