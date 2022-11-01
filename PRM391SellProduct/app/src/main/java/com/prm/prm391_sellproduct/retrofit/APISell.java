package com.prm.prm391_sellproduct.retrofit;

import android.database.Observable;

import com.prm.prm391_sellproduct.model.ModelProductType;
import com.prm.prm391_sellproduct.model.NewProductModel;

import retrofit2.http.GET;

public interface APISell {
    @GET("123")
    Observable<ModelProductType> getModelProductType();

    @GET("")
    Observable<NewProductModel> getNewProductModel();
}
