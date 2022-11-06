package api;

import model.TestProductGet;
import request.AddProductRequest;
import request.LoginRequest;
import request.RegisterRequest;
import response.ProductResponse;
import response.LoginResponse;
import response.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AppService {

    @POST("/sell/auths/jwt")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("/sell/items")
    Call<ProductResponse> addProduct(@Header ("Authorization") String authToken, @Body AddProductRequest addProductRequest);

    @POST("/sell/users")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);

    @GET("/sell/items")
    Call<ProductResponse[]> getAllProduct();

    @GET("/sell/items?page=-1")
    Call<TestProductGet> getAllProductNew();

}
