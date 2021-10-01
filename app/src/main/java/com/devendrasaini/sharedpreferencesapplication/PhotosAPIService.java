package com.devendrasaini.sharedpreferencesapplication;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface PhotosAPIService {
    @GET("v2/list")
    Observable<Response<List<PhotosModel>>> getPhotos();
}
