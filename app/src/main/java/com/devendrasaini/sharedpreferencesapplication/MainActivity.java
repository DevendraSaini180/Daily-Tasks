package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText onLongClickText, onClickText;
    Button btnPress, btnLongPress;
    RelativeLayout touchLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiInitialization();
        startButton();
        startTouchScreen();
    }

    public void uiInitialization() {
        onClickText = findViewById(R.id.editTextOnClick);
        onLongClickText = findViewById(R.id.editTextOnLongClick);
        btnPress = findViewById(R.id.button);
        btnLongPress = findViewById(R.id.button2);
        touchLayout = findViewById(R.id.main_layout);
    }
    private void startButton() {
        startOnClick();
        startOnLongClick();
    }
    private void startOnLongClick() {
        btnLongPress.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLongClickText.setText("onLongClick method is called");
                return false;
            }
        });
    }
    private void startOnClick() {
        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickText.setText("onClick method is called");
            }
        });
    }
    private void startTouchScreen() {
        touchLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(MainActivity.this, "Action Down Event", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity.this, "Action Up Event", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}