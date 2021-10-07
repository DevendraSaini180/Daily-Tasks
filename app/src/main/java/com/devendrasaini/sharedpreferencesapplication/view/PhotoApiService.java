package com.devendrasaini.sharedpreferencesapplication.view;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoApiService {
    //https://picsum.photos/v2/list
    @GET("list")
    Call<List<PhotosModel>> getPhotos();
}
