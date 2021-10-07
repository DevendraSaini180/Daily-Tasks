package com.devendrasaini.sharedpreferencesapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.devendrasaini.sharedpreferencesapplication.R;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Inject
    User user;

    @Inject
    PhotoApiService apiService;

    private TextView name, mApiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiInitialization();
        getUserComoponentInterface();
        setUI();
        callApi();
    }

    public void uiInitialization() {
        name = findViewById(R.id.txtViewName);
        mApiResult = findViewById(R.id.photoList);
    }

    public void getUserComoponentInterface() {
        UserComponent userComponent = DaggerUserComponent.builder()
                .firstName("Devendra")
                .lastName("Saini")
                .build();
        userComponent.inject(this);
    }

    public void setUI() {
        name.setText(user.display() +",My name is "+ user.getFirstName() + " " + user.getLastName());
    }

    public void callApi() {
        Call<List<PhotosModel>> call = apiService.getPhotos();
        call.enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {
                if(!response.isSuccessful()) {
                    mApiResult.setText("Code: " + response.code());
                } else {
                    List<PhotosModel> photos = response.body();
                    for(PhotosModel photo : photos) {
                        String content = "";
                        content += "ID: " + photo.getId() + "\n";
                        content += "Author: " + photo.getAuthor() + "\n";
                        content += "Width: " + photo.getWidth() + "\n";
                        content += "Height: " + photo.getHeight() + "\n";
                        content += "DownloadUrl: " + photo.getDownload_url() + "\n";
                        content += "Url: " + photo.getUrl() + "\n\n";
                        mApiResult.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {
                mApiResult.setText(t.getMessage());
            }
        });
    }

}