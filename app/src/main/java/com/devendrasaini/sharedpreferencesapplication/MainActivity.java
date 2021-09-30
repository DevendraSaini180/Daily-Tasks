package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String mUrl = "https://picsum.photos/";
    RecyclerView mRecyclerView;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiInitialization();
        retrofitBuilder();
        getApiInstance();
        getLayoutManager();
    }
    public void uiInitialization() {
        mRecyclerView = findViewById(R.id.recyclerView);
    }

    public void retrofitBuilder() {
        retrofit = new Retrofit.Builder().baseUrl(mUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public void getApiInstance() {
        PhotosAPIService photosAPICall = retrofit.create(PhotosAPIService.class);

        photosAPICall.getPhotos().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<PhotosModel>>() {
                    @Override
                    public void accept(List<PhotosModel> photosModels) throws Throwable {
                        PhotosListAdapter photosListAdapter = new PhotosListAdapter(photosModels);
                        mRecyclerView.setAdapter(photosListAdapter);
                    }
                });

    }

    public void getLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager
                (getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}