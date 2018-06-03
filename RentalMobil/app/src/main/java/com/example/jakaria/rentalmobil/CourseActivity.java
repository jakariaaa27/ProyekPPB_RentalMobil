package com.example.jakaria.rentalmobil;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CourseActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    ImageView gbr1, gbr2, gbr3, gbr4;
    public final static String TAG_USERNAME = "username";
    public final static String TAG_ID = "id";
    String id, username;
    ProgressDialog progressDialog;

    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    GPSTracker gps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);

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

        gbr3 = (ImageView) findViewById(R.id.btnlocation);
        gbr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gbr3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gps = new GPSTracker(CourseActivity.this);

                        if (gps.canGetLocation()) {
                            double latitude = gps.getLatitude();
                            double longitude = gps.getLongitude();

                            Toast.makeText(getApplicationContext(), "Lokasi kamu adalah - \nLat:"
                                    + latitude + "\nLong:" + longitude, Toast.LENGTH_LONG).show();
                        } else {
                            gps.showSettingAlert();
                        }
                    }
                });

                gbr4 = (ImageView) findViewById(R.id.btnkeluar);
                gbr4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putBoolean(MainActivity.session_status, false);
                        editor.putString(TAG_ID, null);
                        editor.putString(TAG_USERNAME, null);
                        editor.commit();
                        Intent intent = new Intent(CourseActivity.this, MainActivity.class);
                        finish();
                        Toast.makeText(CourseActivity.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                });


            }
        });
    }
}