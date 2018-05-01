package com.example.jakaria.rentalmobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tampilData1();
    }

    public void tampilData1(){
        String strPS = getIntent().getStringExtra("pesan");
        String strKDN = getIntent().getStringExtra("kost");
        String strJM = getIntent().getStringExtra("jam");
        String strTGL = getIntent().getStringExtra("tanggal");

        TextView PSN = findViewById(R.id.PSN);
        TextView KDN = findViewById(R.id.KDN);
        TextView JM = findViewById(R.id.JM);
        TextView TGL = findViewById(R.id.TGL);

        PSN.setText(strPS);
        KDN.setText(strKDN);
        JM.setText(strJM);
        TGL.setText(strTGL);
    }
}