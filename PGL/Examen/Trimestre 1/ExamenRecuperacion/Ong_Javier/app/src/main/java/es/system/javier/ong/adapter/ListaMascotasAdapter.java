package es.system.javier.ong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.system.javier.ong.R;
import es.system.javier.ong.model.Mascota;

public class ListaMascotasAdapter extends RecyclerView.Adapter<ListaMascotasAdapter.ViewHolder> {

    private List<Mascota> listaMascotas;
    private LayoutInflater layoutInflater;
    private Context context;

    final private ListaItemClick listaItemClick;

    /**
     * Interfaz que utilizara los items para realizar una accion al pulsar sobre ellos
     */
    public interface ListaItemClick {
        void onListaItemClick(Mascota clickedMascota);
    }

    /**
     * Constructor con parametros
     * @param mascotas Lista de mascotas que vamos a mostrar
     * @param context de la vista
     * @param listener de la vista
     */
    public ListaMascotasAdapter(List<Mascota> mascotas, Context context, ListaItemClick listener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listaMascotas = mascotas;
        this.listaItemClick = listener;
    }

    /**
     * Método que calcula la cantidad de objetos dentro de la lista
     * @return int con la cantidad de mascotas
     */
    @Override
    public int getItemCount() { return listaMascotas.size(); }

    /**
     * Método que crea el RecyclerView
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ListaMascotasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_mascota, parent, false);
        return new ListaMascotasAdapter.ViewHolder(view);
    }

    /**
     * Método para mostrar los datos de la mascotas dentro del RecyclerView
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ListaMascotasAdapter.ViewHolder holder, final int position) {
        Mascota mascota = listaMascotas.get(position);
        holder.bindPersona(mascota);
    }

    public void setItems(List<Mascota> items) { listaMascotas = items; }

    /**
     * Clase encargada de crear un item por mascota y mostrar sus datos en el RecyclerView
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView identificadorMascota;
        TextView nombreMascota;

        /**
         * Conectar con los campos de la vista
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);

            identificadorMascota = itemView.findViewById(R.id.tvIdentificadorMascota);
            nombreMascota = itemView.findViewById(R.id.tvNombreMascota);
            itemView.setOnClickListener(this);
        }

        /**
         * Insertar los datos en la vista
         * @param mascota datos de la Mascota
         */
        public void bindPersona(final Mascota mascota) {
            identificadorMascota.setText(mascota.getIdentificador());
            nombreMascota.setText(mascota.getNombre());
        }

        /**
         * Agregar al item la opcion de ser pulsado
         * @param view
         */
        @Override
        public void onClick(View view) {
            Mascota mascota = listaMascotas.get(getAdapterPosition());
            listaItemClick.onListaItemClick(mascota);
        }
    }
}
