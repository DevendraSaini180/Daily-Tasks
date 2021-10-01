package com.devendrasaini.sharedpreferencesapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ProgressDialog mProgressDialog;
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
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("loading");
    }

    public void retrofitBuilder() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        retrofit = new Retrofit.Builder().baseUrl(mUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public void getApiInstance() {
        PhotosAPIService photosAPICall = retrofit.create(PhotosAPIService.class);
        mProgressDialog.show();
        photosAPICall.getPhotos().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<List<PhotosModel>>>() {

                               @Override
                               public void accept(Response<List<PhotosModel>> photosModels) throws Throwable {
                                   if (photosModels.code() == 200 && photosModels.isSuccessful()) {
                                       PhotosListAdapter photosListAdapter = new PhotosListAdapter(getApplication(), photosModels.body());
                                       mRecyclerView.setAdapter(photosListAdapter);
                                       mRecyclerView.setItemViewCacheSize(60);
                                   }
                                   mProgressDialog.dismiss();
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Throwable {
                                mProgressDialog.dismiss();
                                Toast.makeText(MainActivity.this, throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                );

    }

    public void getLayoutManager() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager
                (2, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }

}