package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView text_name, text_email, text_password;
    Button btn_logout;

    public static final String MY_PREFERENCES = "MyPrefs";
    public static final String KEY_NAME = "User_Name";
    public static final String KEY_PASSWORD = "User_Password";
    public static final String KEY_EMAIL = "User_Email";

    SharedPreferences sharedPreferences;
    String mName, mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        uiInitialization();
        setSharedPreferences();
        logOut();
    }

    public void uiInitialization() {
        text_name = findViewById(R.id.textView3);
        text_email = findViewById(R.id.textView4);
        text_password = findViewById(R.id.textView5);
        btn_logout = findViewById(R.id.button2);
    }

    public void setSharedPreferences() {
        sharedPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);

        mName = sharedPreferences.getString(KEY_NAME, null);
        mEmail = sharedPreferences.getString(KEY_EMAIL, null);
        mPassword = sharedPreferences.getString(KEY_PASSWORD, null);
        if(checkIsFieldEmpty())
        {
            text_name.setText(KEY_NAME +" -> " +  mName);
            text_email.setText(KEY_EMAIL +" -> " +  mEmail);
            text_password.setText(KEY_PASSWORD +" -> " +  mPassword);
        }
        else
        {
            Toast.makeText(this, "enter user details", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkIsFieldEmpty() {
        if(TextUtils.isEmpty(mName) || TextUtils.isEmpty(mEmail) || TextUtils.isEmpty(mPassword))
        {
            return false;
        }
        return true;
    }

    public void logOut() {
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this, "Logout successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}