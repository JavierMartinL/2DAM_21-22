package es.iespuertodelacruz.javier.zoo.model.contract;

import android.provider.BaseColumns;

public class AnimalContract {

    public static abstract class AnimalEntry implements BaseColumns {
        public static final String TABLE_NAME = "animal";

        public static final String IDENTIFICADOR = "identificador";
        public static final String ESPECIE = "especie";
        public static final String SEXO = "sexo";
        public static final String NACIMIENTO = "nacimiento";
        public static final String PAIS = "pais";
        public static final String CONTINENTE = "continente";
    }

}
