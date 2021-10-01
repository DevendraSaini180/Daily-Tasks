package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

public class Helper extends AppCompatActivity {
    /*
    Provides common methods which are required by multiple classes in the project.
    Helper methods are generally public and static so that these can be invoked independently.
     Each methods of a helper class should work independent of other methods of same class.
     */
    public static boolean isPrime(int number)
    {
        if(number == 2)
        {
            return true;
        }
        for(int i=1;i<=Math.sqrt(number);i++)
        {
            if(number % i == 0 && i != 1)
            {
                return false;
            }
        }
        return true;
    }

    public static long findFactorial(int number) {
        long result = 1;
        for(int i=2;i<=number;i++)
        {
            result = result * i;
        }
        return result;
    }
}
