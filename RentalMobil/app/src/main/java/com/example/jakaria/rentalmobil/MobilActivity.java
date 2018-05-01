package com.example.jakaria.rentalmobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MobilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        RecyclerView rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //ADAPTER
        MobilAdapter adapter = new MobilAdapter(this);
        rv.setAdapter(adapter);
    }
}
