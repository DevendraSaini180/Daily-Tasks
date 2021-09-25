package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textName, textPassword, textEmail;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.button);

        btnSave.setOnClickListener(v -> {
            Bicycle bicycle = new Bicycle();
            bicycle.changeGear(2);
            bicycle.speedUp(3);
            bicycle.applyBrakes(1);

            System.out.println("Bicycle present state : ");
            Toast.makeText(this,"speed of bike is: "+ String.valueOf(bicycle.printStates()), Toast.LENGTH_SHORT).show();

            //creating instance of bike

            Bike bike = new Bike();
            bike.changeGear(1);
            bike.speedUp(4);
            bike.applyBrakes(3);

            System.out.println("Bike present state : ");
            Toast.makeText(this,"speed of bike is: "+String.valueOf(bike.printStates()), Toast.LENGTH_SHORT).show();
        });
    }
}