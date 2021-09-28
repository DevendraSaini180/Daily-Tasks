package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    String URL = "https://en.wikipedia.org/wiki/Wildlife#/media/File:Wildlife_at_Maasai_Mara_(Lion).jpg";
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiInitialization();
        Picasso.with(this)
                .load(URL)
//                .placeholder(R.drawable.ic_launcher_foreground)
//                .error(R.drawable.ic_launcher_background)
                .fit()
                .into(image);
        //loadImageFromUrl();
    }

    public void uiInitialization() {
        image = findViewById(R.id.imageView);
    }

//    public void loadImageFromUrl() {
//
//    }
}