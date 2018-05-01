package com.example.jakaria.rentalmobil;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Pemesanan extends AppCompatActivity implements View.OnClickListener {
    private Button btnjam, btntanggal;
    private LinearLayout parent1;
    private Spinner txtmobil;
    private EditText txtjam, txttanggal;

    private int mYear, mMonth, mDay, mHour, mMinute;

    String[] mobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);
        mobil = getResources().getStringArray(R.array.daftarmobil);
        Spinner s1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mobil);
        s1.setAdapter(adapter);

        btntanggal = (Button) findViewById(R.id.btntanggal);
        btnjam = (Button) findViewById(R.id.btnjam);
        txttanggal = (EditText) findViewById(R.id.txttanggal);
        txtjam = (EditText) findViewById(R.id.txtjam);

        btntanggal.setOnClickListener(this);
        btnjam.setOnClickListener(this);
    }

    public void tampilSecondActivity(View view){
        Intent intentSecondActivity = new Intent(this, SecondActivity.class);

        TextView txtpemesan = findViewById(R.id.txtpemesan);
        Spinner txtkost = findViewById(R.id.spinner);
        TextView txtjam = findViewById(R.id.txtjam);
        TextView txttanggal = findViewById(R.id.txttanggal);

        String strpemesan = txtpemesan.getText().toString();
        String strkost = txtkost.getSelectedItem().toString();
        String strjam = txtjam.getText().toString();
        String strtanngal = txttanggal.getText().toString();

        if (txtpemesan.getText().toString().trim().equals("")){
            txtpemesan.setError("Nama Pemesan tidak boleh kosong");
        } else if (txtkost.getSelectedItem().toString().isEmpty()){
            txtjam.setError("Jenis kost tidak boleh kosong");
        } else if (txtjam.getText().toString().trim().equals("")){
            txtjam.setError("Jam tidak boleh kosong");
        } else if (txttanggal.getText().toString().trim().equals("")){
            txttanggal.setError("Tanngal tidak boleh kosong");
        } else {
            intentSecondActivity.putExtra("pesan", strpemesan);
            intentSecondActivity.putExtra("kost", strkost);
            intentSecondActivity.putExtra("jam", strjam);
            intentSecondActivity.putExtra("tanggal", strtanngal);
            startActivity(intentSecondActivity);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btntanggal:

                Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txttanggal.setText(dayOfMonth +"-"+(monthOfYear+1)+"-"+year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.btnjam:

                c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                txtjam.setText(hourOfDay+":"+minute);
                            }
                        },mHour,mMinute, false);
                timePickerDialog.show();
                break;
        }
    }
}
