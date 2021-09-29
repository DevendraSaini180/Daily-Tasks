package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String mUrl = "https://picsum.photos/200";
    ListView mPhotos;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiInitialization();
        retrofitBuilder();
        getApiInstance();
    }
    public void uiInitialization() {
        mPhotos = findViewById(R.id.imageList);
    }

    public void retrofitBuilder() {
        retrofit = new Retrofit.Builder().baseUrl(mUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getApiInstance() {
        PhotosAPICall photosAPICall = retrofit.create(PhotosAPICall.class);
        Call<List<PhotosModel>> modelCall = photosAPICall.getPhotos();
        modelCall.enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {

            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {

            }
        });
    }
}