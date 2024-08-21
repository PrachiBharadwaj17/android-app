package com.example.dell_pc.libraryproject;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Userreg extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userreg);

        e1 = (EditText) findViewById(R.id.editText5);
        e2 = (EditText) findViewById(R.id.editText6);
        e3 = (EditText) findViewById(R.id.editText9);
        e4 = (EditText) findViewById(R.id.editText10);
        e5 = (EditText) findViewById(R.id.editText12);
        e6 = (EditText) findViewById(R.id.editText13);
    }

    public void sregi(View arg)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {

            Boolean loginStatus = WebService.Newusers(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString(),e6.getText().toString(),"Newuser");

            Toast.makeText(Userreg.this, "Register Successfully", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Userreg.this, userlogin.class);
            startActivity(i);
        }

        catch (Exception e)
        {
            Toast.makeText(Userreg.this, "Exception", Toast.LENGTH_LONG).show();

        }

    }

}
