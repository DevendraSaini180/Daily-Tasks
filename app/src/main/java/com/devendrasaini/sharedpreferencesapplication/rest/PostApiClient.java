package com.devendrasaini.sharedpreferencesapplication.rest;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class PostApiClient {

    /*@Provides annotation tells the dagger how to provide classes that our Project doesn't own
    * or it tells Dagger how to create instance of the type that this function returns */
    @Provides
    PostApiService providePostApiService() {
        return new Retrofit.Builder()
                .baseUrl("https://picsum.photos/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PostApiService.class);
    }
}
