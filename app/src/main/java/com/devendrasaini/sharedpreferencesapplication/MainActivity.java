package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textName, textPassword, textEmail;
    Button btnSave;

    public static final String MY_PREFERENCES = "MyPrefs";
    public static final String KEY_NAME = "User_Name";
    public static final String KEY_PASSWORD = "User_Password";
    public static final String KEY_EMAIL = "User_Email";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.editTextName);
        textPassword = findViewById(R.id.editTextPassword);
        textEmail = findViewById(R.id.editTextEmail);
        btnSave = findViewById(R.id.button);

        sharedPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);


        //When open activity first check shared preferences data available or not
        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        String password = sharedPreferences.getString(KEY_PASSWORD, null);
        if(name != null || email != null || password != null)
        {
            //if data available so directly call Dashboard Activity
            Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
            startActivity(intent);
        }

        btnSave.setOnClickListener(v -> {
            String nameVal = textName.getText().toString();
            String passwordVal = textPassword.getText().toString();
            String emailVal = textEmail.getText().toString();

            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(KEY_NAME, nameVal);
            editor.putString(KEY_PASSWORD, passwordVal);
            editor.putString(KEY_EMAIL, emailVal);
            editor.apply();

            Intent intent = new Intent(MainActivity.this, DashBoardActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        });
    }
}