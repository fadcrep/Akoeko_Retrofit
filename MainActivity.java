package com.example.fad.akoeko_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.fad.akoeko_retrofit.data.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.fad.akoeko_retrofit.ItajaCoreServices.URL_ROOT;

public class MainActivity extends AppCompatActivity {
    private ProductRepository productRepository;
    public static Retrofit buildRetrofit () {
        Gson gson = new GsonBuilder()
                .setLenient()
               .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_ROOT)
               // .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MY-RETROFIT", "oncreate");
        Retrofit retrofit = buildRetrofit();

        ItajaCoreServices itajaCoreServices = retrofit.create(ItajaCoreServices.class);
        Call<List<Product>> callResponse =itajaCoreServices.findAllProducts(1010001073L);
        callResponse.enqueue(new ProductRepository(this));
        Log.d("MY-RETROFIT","last");
    }
}
