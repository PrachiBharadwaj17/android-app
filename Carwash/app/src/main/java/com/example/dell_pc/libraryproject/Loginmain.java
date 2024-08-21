package com.example.dell_pc.libraryproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Loginmain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmain);
    }

    public void gotoalog(View arg)
    {
        Intent i = new Intent(Loginmain.this, Adminlogin.class);
        startActivity(i);
    }


    public void gotoulog(View arg)
    {
        Intent i = new Intent(Loginmain.this, userlogin.class);
        startActivity(i);
    }



}
