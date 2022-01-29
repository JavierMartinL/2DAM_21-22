package es.system.javier.ong.database.contract;

import android.provider.BaseColumns;

public class MascotaContract {

    /**
     * Sentencia para la creación de la tabla en la ddbb
     */
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + MascotaEntry.TABLE_NAME + " (" +
            MascotaEntry._ID + " TEXT, " +
            MascotaEntry.COLUMN_NOMBRE + " TEXT, " +
            MascotaEntry.COLUMN_FECHA_NACIMIENTO + " INTEGER, " +
            MascotaEntry.COLUMN_RAZA + " TEXT," +
            "PRIMARY KEY (" + MascotaEntry._ID + "));";

    /**
     * Sentencia para la eliminación de la tabla en la ddbb
     */
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + MascotaEntry.TABLE_NAME;

    /**
     * Constructor por defecto
     */
    private MascotaContract() {}

    /**
     * Definicion de las propiedades de la tabla
     */
    public static class MascotaEntry implements BaseColumns {
        public static final String TABLE_NAME = "mascotas";

        public static final String COLUMN_NOMBRE = "nombre";
        public static final String COLUMN_FECHA_NACIMIENTO = "fechanacimiento";
        public static final String COLUMN_RAZA = "raza";
    }

}
