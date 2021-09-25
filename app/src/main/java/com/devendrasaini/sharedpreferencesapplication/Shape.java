package com.devendrasaini.sharedpreferencesapplication;

public abstract class Shape {
    String objectName = " ";

    Shape(String name) {
        this.objectName = name;
    }

    // abstract methods which will be implemented by its subclass
    abstract public double area();
}

class Rectangle extends Shape {
    int length, width;

    Rectangle(int length, int width, String name)
    {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return (double)(length*width);
    }
}

class Circle extends Shape {
    double pi = 3.14;
    int radius;

    Circle(int radius, String name)
    {
        super(name);
        this.radius = radius;
    }

    @Override
    public double area() {
        return (double)(pi * radius * radius)/2;
    }
}


