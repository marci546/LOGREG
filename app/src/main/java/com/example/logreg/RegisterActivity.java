package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText txt_email;
    EditText txt_felhaszNev;
    EditText txt_jelszo;
    EditText txt_nev;
    Button bttn_Regisztracio;
    Button bttn_vissza;

    Adatbazis adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        bttn_Regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regisztracio();
            }
        });

        bttn_vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txt_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txt_email.getText().toString().isEmpty() && !txt_felhaszNev.getText().toString().isEmpty() &&
                        !txt_jelszo.getText().toString().isEmpty() && !txt_nev.getText().toString().isEmpty()) {
                    bttn_Regisztracio.setEnabled(true);
                } else {
                    bttn_Regisztracio.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txt_felhaszNev.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txt_email.getText().toString().isEmpty() && !txt_felhaszNev.getText().toString().isEmpty() &&
                        !txt_jelszo.getText().toString().isEmpty() && !txt_nev.getText().toString().isEmpty()) {
                    bttn_Regisztracio.setEnabled(true);
                } else {
                    bttn_Regisztracio.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txt_nev.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txt_email.getText().toString().isEmpty() && !txt_felhaszNev.getText().toString().isEmpty() &&
                        !txt_jelszo.getText().toString().isEmpty() && !txt_nev.getText().toString().isEmpty()) {
                    bttn_Regisztracio.setEnabled(true);
                } else {
                    bttn_Regisztracio.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        txt_jelszo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txt_email.getText().toString().isEmpty() && !txt_felhaszNev.getText().toString().isEmpty() &&
                        !txt_jelszo.getText().toString().isEmpty() && !txt_nev.getText().toString().isEmpty()) {
                    bttn_Regisztracio.setEnabled(true);
                } else {
                    bttn_Regisztracio.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void init() {
        txt_email = findViewById(R.id.txt_email);
        txt_felhaszNev = findViewById(R.id.txt_felhaszNev);
        txt_jelszo = findViewById(R.id.txt_jelszo);
        txt_nev = findViewById(R.id.txt_nev);
        bttn_Regisztracio = findViewById(R.id.bttn_regisztral);
        bttn_vissza = findViewById(R.id.bttn_vissza);
        adatbazis = new Adatbazis(RegisterActivity.this);
    }

    public void Regisztracio() {
        if(!txt_email.getText().toString().isEmpty() && !txt_felhaszNev.getText().toString().isEmpty() &&
                !txt_jelszo.getText().toString().isEmpty() && !txt_nev.getText().toString().isEmpty() &&
                txt_email.getText().toString().contains("@")) {
            boolean allapot = adatbazis.Regisztracio(txt_email.getText().toString(), txt_felhaszNev.getText().toString(),
                    txt_jelszo.getText().toString(), txt_nev.getText().toString());
            if(allapot = true) {
                Toast.makeText(this, "Sikeres regisztráció!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Sikertelen regisztráció!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Az összes mező kitöltése kötelező!", Toast.LENGTH_SHORT).show();
        }
    }
}