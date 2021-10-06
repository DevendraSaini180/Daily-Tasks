package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.devendrasaini.sharedpreferencesapplication.di.CarComponent;
import com.devendrasaini.sharedpreferencesapplication.di.DaggerCarComponent;
import com.devendrasaini.sharedpreferencesapplication.events.Car;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    Car car;
    /* We add this annotation to tell Dagger that it should provide the instance of Car class to
     our MainActivity */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.builder()
                .horsePower(150)
                .engineCapacity(1400)
                .build();
        /* We created a reference to CarComponent to inject MainActivity and DaggerCarComponent Class is created
         by the Dagger for us and will be available after we rebuild the project*/
        component.inject(this);

        /* now we can use drive() method of Car class on car object because dagger has initialized for us */
        car.drive();
    }

}