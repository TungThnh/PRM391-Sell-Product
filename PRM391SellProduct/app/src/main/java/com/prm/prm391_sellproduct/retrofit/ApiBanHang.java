package com.prm.prm391_sellproduct.retrofit;



import com.prm.prm391_sellproduct.model.SanPhamMoiModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiBanHang {
    @GET("/sell/items")
    Observable<SanPhamMoiModel> getSpMoi();
}
