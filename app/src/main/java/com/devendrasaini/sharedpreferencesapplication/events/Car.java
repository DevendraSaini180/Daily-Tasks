package com.devendrasaini.sharedpreferencesapplication.events;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    /*
    In the Main Activity if we want a User class object we will do like this
    Car car = new Car();
    car.drive();
    to execute show method of User class

    But with Dagger we can create User object by creating a component interface and using @Inject
    so now we are creating an interface CarComponent  annotate it with @Component
     */
    private static final String TAG = "Car";

    /* Car class requires instances of Engine and Wheels */
    private Engine engine;
    private Wheels wheels;

    @Inject /* It is known as Constructor Injection , it is used to tell dagger how to create an instance of User. */
    public Car(Engine engine, Wheels wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }

    public void drive() {
        engine.start();
        Log.d(TAG, "driving...");
    }
}