package api;

import com.prm.prm391_sellproduct.response.Items;
import com.prm.prm391_sellproduct.response.ProductFullResponse;
import com.prm.prm391_sellproduct.request.AddProductRequest;
import com.prm.prm391_sellproduct.request.LoginRequest;
import com.prm.prm391_sellproduct.request.RegisterRequest;
import com.prm.prm391_sellproduct.response.ProductResponse;
import com.prm.prm391_sellproduct.response.LoginResponse;
import com.prm.prm391_sellproduct.response.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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
    Call<ProductFullResponse> getAllProductNew();

    @GET("/sell/items?page=-1&filter[record_status]=O")
    Call<ProductFullResponse> getAllProductForMain();

    @PUT("/sell/items/" + "/{id}")
    Call<Items> updateProduct(@Path("id") Object id, @Body Items items);

}
