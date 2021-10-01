package com.devendrasaini.sharedpreferencesapplication.di;

import com.devendrasaini.sharedpreferencesapplication.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract PetrolEngine bindEngine(PetrolEngine engine);
}
