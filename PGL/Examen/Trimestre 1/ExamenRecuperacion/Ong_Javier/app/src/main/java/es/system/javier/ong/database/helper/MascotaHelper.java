package es.system.javier.ong.database.helper;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import es.system.javier.ong.database.contract.MascotaContract;
import es.system.javier.ong.model.Mascota;

public class MascotaHelper extends ComunHelper {

    public MascotaHelper(Context context) {
        super(context);
    }

    /**
     * Método que realiza la busqueda de todos las Mascotas
     * @return Lista de Mascotas
     */
    public List<Mascota> searchAll() {
        List<Mascota> mascotas = new ArrayList<>();
        Cursor cursor = super.search(MascotaContract.MascotaEntry.TABLE_NAME);

        if (cursor.moveToFirst()) {
            do {
                mascotas.add(new Mascota(
                        cursor.getString(cursor.getColumnIndexOrThrow(MascotaContract.MascotaEntry._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MascotaContract.MascotaEntry.COLUMN_NOMBRE)),
                        cursor.getLong(cursor.getColumnIndexOrThrow(MascotaContract.MascotaEntry.COLUMN_FECHA_NACIMIENTO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MascotaContract.MascotaEntry.COLUMN_RAZA))
                ));
            } while (cursor.moveToNext());
            cursor.close();
        }

        return mascotas;
    }

    /**
     * Método que realiza la busqueda de una mascota segun el identificador
     * @param id identificador de la mascota que queremos buscar
     * @return Objeto Mascota con sus datos
     */
    public Mascota searchOne(String id) {
        Mascota mascota = null;
        String selection = MascotaContract.MascotaEntry._ID + " = ?";
        String[] selectionArgs = {id};

        Cursor cursor = super.search(
                MascotaContract.MascotaEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                mascota = new Mascota(
                        cursor.getString(cursor.getColumnIndexOrThrow(MascotaContract.MascotaEntry._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MascotaContract.MascotaEntry.COLUMN_NOMBRE)),
                        cursor.getLong(cursor.getColumnIndexOrThrow(MascotaContract.MascotaEntry.COLUMN_FECHA_NACIMIENTO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(MascotaContract.MascotaEntry.COLUMN_RAZA))
                );
            } while (cursor.moveToNext());
            cursor.close();
        }

        return mascota;
    }

    /**
     * Método encargado de realizar la insercion
     * @param mascota con los datos a insertar
     * @return True si se inserta la mascota
     */
    public boolean save(Mascota mascota) {
        return super.save(
                MascotaContract.MascotaEntry.TABLE_NAME,
                mascota.toContentValues()
        );
    }

    /**
     * Método encargado de realizar la actualizacion
     * @param mascota con los datos a actualizar
     * @return True si se actualiza la mascota
     */
    public boolean update(Mascota mascota) {
        String selection = MascotaContract.MascotaEntry._ID + " = ?";
        String[] selectionArgs = {mascota.getIdentificador()};

        return super.update(
                MascotaContract.MascotaEntry.TABLE_NAME,
                mascota.toContentValues(),
                selection,
                selectionArgs
        );
    }

    /**
     * Método encargado de realizar la eliminacion
     * @param mascota con los datos a eliminar
     * @return True si se elimina la mascota
     */
    public boolean delete(Mascota mascota) {
        String selection = MascotaContract.MascotaEntry._ID + " = ?";
        String[] selectionArgs = {mascota.getIdentificador()};

        return super.delete(
                MascotaContract.MascotaEntry.TABLE_NAME,
                selection,
                selectionArgs
        );
    }
}
