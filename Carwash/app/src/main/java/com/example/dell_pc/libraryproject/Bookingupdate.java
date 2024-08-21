package com.example.dell_pc.libraryproject;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Bookingupdate extends AppCompatActivity {
    TextView t1,t2;
    String usern,bid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingupdate);

        t1 = (TextView) findViewById(R.id.textView3);
        t2 = (TextView) findViewById(R.id.textView4);
        Intent ii = getIntent();
        usern = ii.getStringExtra("userid");
        bid = ii.getStringExtra("Bid");

        t1.setText(usern);
        t2.setText(bid);
    }


    public void goho(View arg)
    {
        Intent i = new Intent(this, Userhome.class);
        i.putExtra("userid",t1.getText().toString());
        startActivity(i);
    }

    public void updi(View arg)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {

            Boolean loginStatus = WebService.cancelbooking(t2.getText().toString(),"cancelbook");

            Toast.makeText(this, "Cancel Successfully", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, Userhome.class);
            i.putExtra("userid",t1.getText().toString());
            startActivity(i);


        }

        catch (Exception e)
        {
            Toast.makeText(this, "Exception", Toast.LENGTH_LONG).show();

        }

    }

}
