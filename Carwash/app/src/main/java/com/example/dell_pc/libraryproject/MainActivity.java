package com.example.dell_pc.libraryproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickhere(View v)
    {
        Intent i = new Intent(MainActivity.this, Loginmain.class);
        startActivity(i);
    }
}
