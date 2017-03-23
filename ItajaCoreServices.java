package com.example.fad.akoeko_retrofit;

import com.example.fad.akoeko_retrofit.data.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ItajaCoreServices {
    final static String URL_ROOT = "http://104.155.151.29:9010/v1/";

    @GET("/companies/{companyId}/products")
    Call<List<Product>> findAllProducts(@Path("companyId") Long companyId);
}
