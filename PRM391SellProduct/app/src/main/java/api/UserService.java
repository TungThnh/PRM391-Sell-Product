package api;

import request.AddProductRequest;
import request.LoginRequest;
import response.AddNewProductResponse;
import response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("/sell/auths/jwt")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("sell/items")
    Call<AddNewProductResponse> addProduct(@Body AddProductRequest addProductRequest);


}
