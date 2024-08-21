package com.example.dell_pc.libraryproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.StrictMode;
import android.widget.Toast;

public class Updatestatus extends AppCompatActivity {
    EditText e1;
    TextView t1,t2;
    String usern,oid,dept,syear;
    Spinner s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatestatus);

        Intent ii = getIntent();
        t1 = (TextView) findViewById(R.id.textView14);
        t2 = (TextView) findViewById(R.id.textView15);
        s1 = (Spinner) findViewById(R.id.spinner4);

        oid = ii.getStringExtra("oid");
        usern = ii.getStringExtra("userid");
        t1.setText(usern);
        t2.setText(oid);
    }



   }
