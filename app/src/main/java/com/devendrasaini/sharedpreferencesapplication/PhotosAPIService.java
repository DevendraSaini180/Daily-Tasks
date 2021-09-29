package com.devendrasaini.sharedpreferencesapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotosAPIService {
    @GET("v2/list")
    Call<List<PhotosModel>> getPhotos();
}
