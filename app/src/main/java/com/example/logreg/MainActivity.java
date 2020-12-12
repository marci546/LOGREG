package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_felhaszNev;
    EditText txt_jelszo;
    Button bttn_bejelentkezes;
    Button bttn_regisztracio;
    Adatbazis adatbazis;

    SharedPreferences felhasznaloAdatai;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        bttn_bejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bejelentkezes();
            }
        });

        bttn_regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void init() {
        txt_felhaszNev = findViewById(R.id.txt_felhaszNev);
        txt_jelszo = findViewById(R.id.txt_jelszo);
        bttn_bejelentkezes = findViewById(R.id.bttn_bejelentkezes);
        bttn_regisztracio = findViewById(R.id.bttn_regisztral);

        adatbazis = new Adatbazis(MainActivity.this);

        felhasznaloAdatai = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        edit = felhasznaloAdatai.edit();
    }

    private void Bejelentkezes() {
        if(!(txt_felhaszNev.getText().toString().isEmpty() && txt_jelszo.getText().toString().isEmpty())) {
            Cursor adatok = adatbazis.Bejelentkezes(txt_felhaszNev.getText().toString(), txt_jelszo.getText().toString());
            if(adatok.getCount() == 1) {
                Intent intent = new Intent(MainActivity.this, LoggedinActivity.class);
                while (adatok.moveToNext()){
                    intent.putExtra("nev", adatok.getString(0));
                }
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Helytelen felhasználói adatok", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Adjon meg felhasználói adatokat!", Toast.LENGTH_SHORT).show();
        }
    }
}