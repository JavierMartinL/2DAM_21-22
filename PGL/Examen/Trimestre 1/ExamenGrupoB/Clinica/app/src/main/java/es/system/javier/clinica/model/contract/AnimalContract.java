package es.system.javier.clinica.model.contract;

import android.provider.BaseColumns;

public class AnimalContract {

    public static abstract class AnimalEntry implements BaseColumns {
        // Nombre de la tabla
        public static final String TABLE_NAME = "animal";

        // Atributos de la tabla
        public static final String IDENTIFICADOR = "identificador";
        public static final String NOMBRE = "nombre";
        public static final String RAZA = "raza";
        public static final String EDAD = "edad";
        public static final String CHIP = "chip";
    }

}