package es.system.javier.tresenraya.networking.connection.service;

import java.util.List;

import es.system.javier.tresenraya.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("users")
    Call<List<User>> getUsers();

}
