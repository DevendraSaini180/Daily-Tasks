package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String mUrl = "https://picsum.photos/";
    TextView mApiResult;
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
        mApiResult = findViewById(R.id.imageList);
    }

    public void retrofitBuilder() {
        retrofit = new Retrofit.Builder().baseUrl(mUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void getApiInstance() {
        PhotosAPIService photosAPICall = retrofit.create(PhotosAPIService.class);
        Call<List<PhotosModel>> modelCall = photosAPICall.getPhotos();
        modelCall.enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {

                if(!response.isSuccessful())
                {
                    mApiResult.setText("Code: " + response.code());
                }

                List<PhotosModel> photos = response.body();
                for (PhotosModel photo : photos )
                {
                    String content = "";
                    content += "ID: " + photo.getId() + "\n";
                    content += "Author: " + photo.getAuthor() + "\n";
                    content += "Url: " + photo.getUrl() + "\n\n";
                    mApiResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {
                mApiResult.setText(t.getMessage());
            }
        });
    }
}