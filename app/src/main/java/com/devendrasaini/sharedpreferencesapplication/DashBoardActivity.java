package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity {

    TextView text_name, text_email, text_password;
    Button btn_logout;

    public static final String MY_PREFERENCES = "MyPrefs";
    public static final String KEY_NAME = "User_Name";
    public static final String KEY_PASSWORD = "User_Password";
    public static final String KEY_EMAIL = "User_Email";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        text_name = findViewById(R.id.textView3);
        text_email = findViewById(R.id.textView4);
        text_password = findViewById(R.id.textView5);
        btn_logout = findViewById(R.id.button2);

        sharedPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);
        String password = sharedPreferences.getString(KEY_PASSWORD, null);

        if(name != null || email != null || password != null)
        {
            text_name.setText(KEY_NAME +" -> " +  name);
            text_email.setText(KEY_EMAIL +" -> " +  email);
            text_password.setText(KEY_PASSWORD +" -> " +  password);
        }

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(DashBoardActivity.this, "Logout successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }


}