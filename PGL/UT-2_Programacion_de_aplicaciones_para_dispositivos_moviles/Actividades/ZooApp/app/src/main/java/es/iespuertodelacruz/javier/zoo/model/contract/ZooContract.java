package es.iespuertodelacruz.javier.zoo.model.contract;

import android.provider.BaseColumns;

public class ZooContract {

    public static abstract class ZooEntry implements BaseColumns {
        public static final String TABLE_NAME = "zoo";

        public static final String NOMBRE = "nombre";
        public static final String CIUDAD = "ciudad";
        public static final String PAIS = "pais";
        public static final String TAMANIO = "tamanio";
        public static final String PRESUPUESTO_ANUAL = "presupuestoAnual";
    }

}
