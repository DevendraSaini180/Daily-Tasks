package com.devendrasaini.sharedpreferencesapplication.di;

import com.devendrasaini.sharedpreferencesapplication.MainActivity;
import com.devendrasaini.sharedpreferencesapplication.car.Car;

import dagger.Component;
import dagger.internal.DaggerCollections;

@Component(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {


    Car getCar();
    void inject(MainActivity mainActivity);
}
