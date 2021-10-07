package com.devendrasaini.sharedpreferencesapplication.view;



import javax.inject.Inject;
import javax.inject.Named;

public class User{

    Address address;
    String firstName, lastName;

    @Inject
    public User(Address address, @Named("firstName") String firstName,@Named("lastName") String lastName) {
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String display() {
//        Toast.makeText(this, "User class: display method invoked", Toast.LENGTH_SHORT).show();
        return "Hello" + address.userAddress();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
