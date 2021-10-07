package com.devendrasaini.sharedpreferencesapplication.view;

import android.app.Activity;

import javax.inject.Inject;

public class Address extends Activity {

    @Inject
    public Address() {

    }

    public String userAddress() {
//        Toast.makeText(this, "Address class instantiated", Toast.LENGTH_SHORT).show();
        return " everyone ";
    }
}
