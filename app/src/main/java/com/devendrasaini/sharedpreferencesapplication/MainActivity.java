package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText rectArea, textPassword, rectCircle;
    Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiInitialization();
        btnLogin();
    }

    public void uiInitialization() {
        rectArea = findViewById(R.id.editTextName);
        rectCircle = findViewById(R.id.editTextEmail);
        btnSave = findViewById(R.id.button);
    }
    public void btnLogin() {
        btnSave.setOnClickListener(v -> {
            interfaceDemo();
            abstractDemo();
        });
    }
    public void interfaceDemo() {
        Bicycle bicycle = new Bicycle();
        bicycle.changeGear(2);
        bicycle.speedUp(3);
        bicycle.applyBrakes(1);

        Toast.makeText(this,"speed of bike is: "+ String.valueOf(bicycle.printStates()), Toast.LENGTH_SHORT).show();

        Bike bike = new Bike();
        bike.changeGear(1);
        bike.speedUp(4);
        bike.applyBrakes(3);

        Toast.makeText(this,"speed of bike is: "+String.valueOf(bike.printStates()), Toast.LENGTH_SHORT).show();
    }
    public void abstractDemo() {
        Shape rect = new Rectangle(2, 3, "Rectangle");

        Shape circle = new Circle(2, "Circle");

        rectArea.setText("Area of rectangle: " +String.valueOf(rect.area()));

        rectCircle.setText("Area of circle: " + String.valueOf(circle.area()));
    }
}