package com.example.jakaria.rentalmobil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CourseActivity extends AppCompatActivity {
    ImageView gbr1,gbr2,gbr3;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        gbr1 = (ImageView) findViewById(R.id.btnmobil);
        gbr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), MobilActivity.class);
                startActivity(i);
            }
        });

        gbr2 = (ImageView) findViewById(R.id.btnpesan);
        gbr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), Pemesanan.class);
                startActivity(i);
            }
        });

        gbr3 = (ImageView) findViewById(R.id.btnabout);
        gbr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = null;
                i = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(i);
            }
        });
    }
}
