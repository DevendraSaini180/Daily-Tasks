package com.devendrasaini.sharedpreferencesapplication.view;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class PhotoApiClient {

    @Provides
    PhotoApiService providePhotoApiService() {
        return new Retrofit.Builder()
                .baseUrl("https://picsum.photos/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PhotoApiService.class);
    }
}
