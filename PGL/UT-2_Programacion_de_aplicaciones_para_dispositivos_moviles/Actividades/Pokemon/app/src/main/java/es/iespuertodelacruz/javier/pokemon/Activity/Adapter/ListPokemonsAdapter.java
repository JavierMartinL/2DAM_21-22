package es.iespuertodelacruz.javier.pokemon.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import es.iespuertodelacruz.javier.pokemon.R;
import es.iespuertodelacruz.javier.pokemon.api.Pokemon;

public class ListPokemonsAdapter extends RecyclerView.Adapter<ListPokemonsAdapter.ViewHolder> {

    private List<Pokemon> mPokemonsList;
    private LayoutInflater mInflater;
    private Context context;

    final private ListItemClick mOnClickListener;

    public ListPokemonsAdapter(List<Pokemon> itemList, Context context, ListItemClick listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mPokemonsList = itemList;
        this.mOnClickListener = listener;
    }

    public interface ListItemClick {
        void onListItemClick(Pokemon clickedItem);
    }

    @Override
    public int getItemCount() { return mPokemonsList.size(); }

    @Override
    public ListPokemonsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_pokemon, parent, false);
        return new ListPokemonsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListPokemonsAdapter.ViewHolder holder, final int position) {
        Pokemon pokemon = mPokemonsList.get(position);
        holder.bindPokemon(pokemon);

        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokemon.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imagePokemon);
    }

    public void setItems(List<Pokemon> items) { mPokemonsList = items; }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView namePokemon;
        ImageView imagePokemon;

        public ViewHolder(View itemView) {
            super(itemView);

            namePokemon = itemView.findViewById(R.id.tvNamePokemon );
            imagePokemon = itemView.findViewById(R.id.fotoPokemon);
            itemView.setOnClickListener(this);
        }

        public void bindPokemon(final Pokemon item) {
            namePokemon.setText(item.getName());
        }

        @Override
        public void onClick(View view) {
            Pokemon pokemon = mPokemonsList.get(getAbsoluteAdapterPosition());
            mOnClickListener.onListItemClick(pokemon);
        }
    }

}
