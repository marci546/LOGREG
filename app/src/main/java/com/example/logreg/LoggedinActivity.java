package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedinActivity extends AppCompatActivity {

    TextView tv_felhaszNev;
    Button bttn_kijelentkezes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);
        init();

        bttn_kijelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedinActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv_felhaszNev.setText(getIntent().getStringExtra("nev"));
    }

    private void init() {
        tv_felhaszNev = findViewById(R.id.tv_felhaszNev);
        bttn_kijelentkezes = findViewById(R.id.bttn_kijelentkezes);
    }
}