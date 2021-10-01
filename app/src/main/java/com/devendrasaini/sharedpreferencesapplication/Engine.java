package com.devendrasaini.sharedpreferencesapplication;

public class Engine {
    Block block;
    Cylinders cylinders;
    SparkPlugs sparkPlugs;

    public Engine(Block block, Cylinders cylinders, SparkPlugs sparkPlugs) {
        this.block = block;
        this.cylinders = cylinders;
        this.sparkPlugs = sparkPlugs;
    }
}
