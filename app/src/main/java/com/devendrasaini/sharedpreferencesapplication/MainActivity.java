package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    String URL = "https://images.unsplash.com/photo-1631473126856-d1fdf3bf9c4f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=435&q=80";
    ImageView image, glideImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiInitialization();
        loadImageUrlFromPicasso();
    }
    public void uiInitialization() {
        image = findViewById(R.id.imageView);
        glideImage = findViewById(R.id.imageViewG);
    }
    public void loadImageUrlFromPicasso() {
        Picasso.with(this)
                .load(URL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .into(image);
    }
}