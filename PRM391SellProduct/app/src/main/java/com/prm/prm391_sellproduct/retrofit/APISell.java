package com.prm.prm391_sellproduct.retrofit;

import android.database.Observable;

import com.prm.prm391_sellproduct.model.ModelProductType;

import retrofit2.http.GET;

public interface APISell {
    @GET("/items")
    Observable<ModelProductType> getProductType;
}
