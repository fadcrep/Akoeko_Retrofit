package com.example.fad.akoeko_retrofit;

import android.content.Context;
import android.util.Log;

import com.example.fad.akoeko_retrofit.data.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Crepin Hugues FADJO (f@dcrepin) on 22/03/2017.
 */

public class ProductRepository implements retrofit2.Callback<List<Product>> {

    private Context context;

    public ProductRepository(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
        if (response.isSuccessful()) {
            List<Product> ProductList = response.body();
            for (Product product : ProductList) {
                Log.d("MY-RETROFIT",product.getName() + "/n");
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Product>> call, Throwable t) {
        Log.e("MY-RETROFIT","echec total",t);
    }
}




