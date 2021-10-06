package com.devendrasaini.sharedpreferencesapplication.rest;

import com.devendrasaini.sharedpreferencesapplication.model.PhotosModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApiService {
    /*We use @Inject on constructors but what if we want an object of class
    * that we don't own or an interface that doesn't have constructor in those case we use @Module
    * we will create instance of PostApiService interface */

    @GET("list")
    Call<List<PhotosModel>> getPhotos();
}
