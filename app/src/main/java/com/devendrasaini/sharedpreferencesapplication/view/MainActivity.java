package com.devendrasaini.sharedpreferencesapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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


    TextView name;
    RecyclerView recyclerView;
    PhotoListAdapter listAdapter;

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
        recyclerView = findViewById(R.id.recyclerView);
    }

    public void getUserComoponentInterface() {
        UserComponent userComponent = DaggerUserComponent.builder()
                .firstName("Devendra")
                .lastName("Saini")
                .build();
        userComponent.inject(this);
    }

    @SuppressLint("SetTextI18n")
    public void setUI() {
        name.setText(user.display() +",My name is "+ user.getFirstName() + " " + user.getLastName());
    }

    public void callApi() {
        Call<List<PhotosModel>> call = apiService.getPhotos();
        call.enqueue(new Callback<List<PhotosModel>>() {
            @Override
            public void onResponse(Call<List<PhotosModel>> call, Response<List<PhotosModel>> response) {

                    listAdapter = new PhotoListAdapter(getApplicationContext(), response.body());
                    recyclerView.setAdapter(listAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
            }

            @Override
            public void onFailure(Call<List<PhotosModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}