package com.devendrasaini.sharedpreferencesapplication.di;

import com.devendrasaini.sharedpreferencesapplication.car.DieselEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {

    @Binds
    abstract DieselEngine bindEngine(DieselEngine engine);
}
