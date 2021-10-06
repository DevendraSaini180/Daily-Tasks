package com.devendrasaini.sharedpreferencesapplication.di;

import com.devendrasaini.sharedpreferencesapplication.MainActivity;
import com.devendrasaini.sharedpreferencesapplication.events.Car;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {WheelsModule.class, PetrolEngineModule.class})
public interface CarComponent {

    Car getCar();
    void inject(MainActivity mainActivity);

    /*
    The inject method is used to tell Dagger that MainActivity wants to access DAG(Directed Acyclic Graph)
    and Dagger should provide all Dependencies that the MainActivity request.
     */

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("horse power") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

        CarComponent build();
    }
}
