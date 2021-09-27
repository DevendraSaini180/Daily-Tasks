package com.devendrasaini.sharedpreferencesapplication;

public class SingletonExample {
    String editValue;
    private static SingletonExample object = null;

    private SingletonExample() {}

    public static SingletonExample getInstance() {
        if(object == null)
        {
            object = new SingletonExample();
        }
        return object;
    }

    public String getText() {
        return editValue;
    }

    public void setText(String editValue) {
        this.editValue = editValue;
    }
}
