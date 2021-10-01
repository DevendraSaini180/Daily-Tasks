package com.devendrasaini.sharedpreferencesapplication;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PhotosAPIService {
    @GET("list")
    Observable<List<PhotosModel>> getPhotos();
}
