package com.devendrasaini.sharedpreferencesapplication;

public interface Vehicle {
    void changeGear(int a);
    void speedUp(int a);
    void applyBrakes(int a);
}

class Bicycle implements Vehicle {
    int speed;
    int gear;
    @Override
    public void changeGear(int newGear)
    {
        gear = newGear;
    }

    // to increase speed
    @Override
    public void speedUp(int increment) {
        speed = speed + increment;
    }

    // to decrease speed
    @Override
    public void applyBrakes(int decrement)
    {
        speed = speed - decrement;
    }

    public int printStates() {
        return speed + gear;
    }
}

class Bike implements Vehicle {
    int speed;
    int gear;

    // to change gear
    @Override
    public void changeGear(int newGear)
    {
        gear = newGear;
    }

    //to increase speed
    @Override
    public void speedUp(int increment)
    {
        speed = speed - increment;
    }

    // to decrease speed
    @Override
    public void applyBrakes(int decrement) {
        speed =speed - decrement;
    }

    public int printStates() {
        return speed + gear;
    }
}
