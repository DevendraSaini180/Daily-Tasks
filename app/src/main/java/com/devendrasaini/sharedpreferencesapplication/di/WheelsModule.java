package com.devendrasaini.sharedpreferencesapplication.di;

import com.devendrasaini.sharedpreferencesapplication.events.Rims;
import com.devendrasaini.sharedpreferencesapplication.events.Tires;
import com.devendrasaini.sharedpreferencesapplication.events.Wheels;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class WheelsModule {

    @Provides
    static Rims provideRims() {
        return new Rims();
    }

    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
