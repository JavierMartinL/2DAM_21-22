package es.iespuertodelacruz.javier.zoo.model.contract;

import android.provider.BaseColumns;

public class EspecieContract {

    public static abstract class EspecieEntry implements BaseColumns {
        public static final String TABLE_NAME = "especie";

        public static final String NOMBRE_VULGAR = "nombreVulgar";
        public static final String NOMBRE_CIENTIFICO = "nombreCientifico";
        public static final String FAMILIA = "familia";
        public static final String PELIGRO_EXTINCION = "peligroExtincion";
    }

}
