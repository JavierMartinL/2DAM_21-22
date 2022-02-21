package es.system.javier.tresenraya.networking.connection;

import es.system.javier.tresenraya.networking.connection.retrofit.RetrofitClient;
import es.system.javier.tresenraya.networking.connection.service.UserService;

public class APIUtils {

    private APIUtils() { }

    public static final String API_URL = "https://gorest.co.in/public/v2/";

    public static UserService getUserService() {
        return RetrofitClient.getClient(API_URL).create(UserService.class);
    }

}
