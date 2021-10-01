package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Block block = new Block();
        Cylinders cylinders = new Cylinders();
        SparkPlugs sparkPlugs = new SparkPlugs();

        Tires tires = new Tires();
        Rims rims = new Rims();

        Engine engine = new Engine(block, cylinders, sparkPlugs);
        Wheels wheels = new Wheels(tires, rims);
        /*
        Without Dagger we have to do lot of initialization if Block class depends on another class
        then we have to make objects this is called manual dependency injection

        we tell Dagger to how to construct all these objects and then it creates them at the right time and
        in the right order
         */

        Car car = new Car(engine,wheels);
        car.drive();
    }

}