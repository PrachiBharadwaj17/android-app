package com.example.dell_pc.libraryproject;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Addcategory extends AppCompatActivity {
    EditText e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategory);
        e1 = (EditText) findViewById(R.id.editText8);
        e2 = (EditText) findViewById(R.id.editText9);
        e3 = (EditText) findViewById(R.id.editText10);
    }

    public void Addca(View arg)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {

            Boolean loginStatus = WebService.Addservice(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(), "Addservice");

            Toast.makeText(this, "Added Successfully", Toast.LENGTH_LONG).show();

        }

        catch (Exception e)
        {
            Toast.makeText(this, "Exception", Toast.LENGTH_LONG).show();

        }

    }


}
