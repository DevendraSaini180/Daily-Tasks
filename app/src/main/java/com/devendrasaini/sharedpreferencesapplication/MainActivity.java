package com.devendrasaini.sharedpreferencesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText, editNumber;
    TextView primeNumber, factorial;
    Button btnSave, btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiInitialization();
        startButton();
        startCalculationButton();
    }

    public void uiInitialization() {
        editText = findViewById(R.id.editText);
        editNumber = findViewById(R.id.editTextNumber);
        primeNumber = findViewById(R.id.textViewPrime);
        factorial = findViewById(R.id.textViewFact);
        btnSave = findViewById(R.id.button);
        btnCalculate = findViewById(R.id.button2);
    }
    private void startButton() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().isEmpty())
                {
                    editText.setError("Enter Text");
                }
                else
                {
                    String editValue = editText.getText().toString();
                    SingletonExample singletonexample = SingletonExample.getInstance();
                    singletonexample.setText(editValue);
                    Toast.makeText(MainActivity.this, singletonexample.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void startCalculationButton() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Helper.isPrime(Integer.parseInt(editNumber.getText().toString())))
                {
                    primeNumber.setText(editNumber.getText().toString()+" is a Prime Number");
                }
                else
                {
                    primeNumber.setText(editNumber.getText().toString()+" is not a Prime Number");
                }
                factorial.setText("factorial of " + editNumber.getText().toString()+" = " + Helper.findFactorial(Integer.parseInt(editNumber.getText().toString())));
            }
        });
    }
}