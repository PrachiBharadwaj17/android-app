package com.example.dell_pc.libraryproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class Adminlogin extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        e1 = (EditText) findViewById(R.id.editText8);
        e2 = (EditText) findViewById(R.id.editText14);
    }

    public void alogg(View arg)
    {

        if(e1.getText().toString().equals("admin") &&
                e2.getText().toString().equals("admin"))
        {

            Toast.makeText(getApplicationContext(),
                    "Redirecting...",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,Adminhome.class);
            startActivity(i);
        }

        else
        {
            Toast.makeText(getApplicationContext(), "Wrong",Toast.LENGTH_SHORT).show();


        }

    }
}
