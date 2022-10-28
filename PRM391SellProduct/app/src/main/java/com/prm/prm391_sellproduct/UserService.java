package com.prm.prm391_sellproduct;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/auths/jwt/")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

}
