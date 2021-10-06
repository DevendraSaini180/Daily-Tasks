package com.devendrasaini.sharedpreferencesapplication.events;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

/*
  In the Main Activity if we want a User class object we will do like this
  User user = new User();
  mUser.show();
  to execute show method of User class

  But with Dagger we can create User object by creating a component interface and using @Inject
  so now we are creating an interface UserComponent  annotate it with @Component
   */
public class User extends AppCompatActivity {
    /* User class has dependency on Address class*/
    private Address mAddress;

    /* User class has dependency on two String  mFirstName, mLastName*/

    /* To supply firstName and lastName we have to create an interface inside UserComponent interface
     annotate it with @Component.Builder */
    private String mFirstName, mLastName;

    /* It is known as Constructor Injection , it is used to tell dagger how to create an instance of User class. */
    @Inject
    public User(Address address,
                @Named("firstName") String firstName,
                @Named("lastName") String lastName) {
        this.mAddress = address;
        this.mFirstName = firstName;
        this.mLastName = lastName;
    }

    public void display() {
        Toast.makeText(User.this, "User class: display method invoked", Toast.LENGTH_SHORT).show();
        mAddress.userAddress();
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }
}
