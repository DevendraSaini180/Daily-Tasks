package com.devendrasaini.sharedpreferencesapplication.events;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

/* Address class is dependency of User class*/
public class Address extends AppCompatActivity {

    @Inject
    public Address() {

    }

    public void userAddress() {
        Toast.makeText(this, "Address class instantiated", Toast.LENGTH_SHORT).show();
    }
}
