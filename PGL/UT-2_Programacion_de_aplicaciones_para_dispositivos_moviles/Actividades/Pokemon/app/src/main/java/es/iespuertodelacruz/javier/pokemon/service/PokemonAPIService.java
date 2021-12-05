package es.iespuertodelacruz.javier.pokemon.service;

import es.iespuertodelacruz.javier.pokemon.api.PokemonFetchResults;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonAPIService {

    @GET("pokemon")
    Call<PokemonFetchResults> getPokemons();

}
