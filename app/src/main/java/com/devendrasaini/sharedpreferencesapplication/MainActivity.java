package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.devendrasaini.sharedpreferencesapplication.di.DaggerUserComponent;
import com.devendrasaini.sharedpreferencesapplication.di.UserComponent;
import com.devendrasaini.sharedpreferencesapplication.events.User;
import com.devendrasaini.sharedpreferencesapplication.model.PhotosModel;
import com.devendrasaini.sharedpreferencesapplication.rest.PostApiService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    /* We add this annotation to tell Dagger that it should provide the instance of User class to
     our MainActivity */
    @Inject
    User mUser;

    @Inject
    PostApiService postApiService;

    @Inject
    PhotosModel photosModel;

    private TextView mName, mApiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiInitialization();

        /* We created a reference to UserComponent to inject MainActivity and DaggerUserComponent Class is created
         by the Dagger for us and will be available after we rebuild the project*/
        UserComponent component = DaggerUserComponent.builder()
                .firstName("Devendra")
                .lastName("Saini")
                .build();

        /* now we can use show() method of User class on user object because dagger has initialized for us */
        component.inject(this);

        mUser.display();
        mName.setText("FirstName: " + mUser.getmFirstName() + "\nLastName: " + mUser.getmLastName());
        getApiService();
    }

    public void uiInitialization() {
        mName = findViewById(R.id.txtViewName);
        mApiResult = findViewById(R.id.postsList);
    }

    public void getApiService() {
        Call<List<PhotosModel>> call = postApiService.getPhotos();
        call.enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {
                if(!response.isSuccessful()) {
                    mApiResult.setText("Code: " + response.code());
                }

                List<PhotosModel> photos = response.body();
                for(PhotosModel photosModel : photos) {
                    String content = "";
                    content += "ID: " + photosModel.getId() + "\n";
                    content += "Author: " + photosModel.getAuthor() + "\n";
                    content += "Width: " + photosModel.getWidth() + "\n";
                    content += "Height: " + photosModel.getHeight() + "\n";
                    content += "DownloadUrl: " + photosModel.getDownload_url() + "\n";
                    content += "Url: " + photosModel.getUrl() + "\n\n";
                    mApiResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {
                mApiResult.setText(t.getMessage());
            }
        });
    }

}