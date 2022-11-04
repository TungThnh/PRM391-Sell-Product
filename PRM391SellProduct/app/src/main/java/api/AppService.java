package api;

import request.AddProductRequest;
import request.LoginRequest;
import response.ProductResponse;
import response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AppService {

    @POST("/sell/auths/jwt")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("sell/items")
    Call<ProductResponse> addProduct(@Header ("Authorization") String authToken, @Body AddProductRequest addProductRequest);

    @GET("sell/items")
    Call<ProductResponse[]> getAllProduct();

}
