package api;

import model.LoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/sell/auths/jwt")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);




}
