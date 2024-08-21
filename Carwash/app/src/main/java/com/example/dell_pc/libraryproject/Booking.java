package com.example.dell_pc.libraryproject;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import android.app.DatePickerDialog;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;


public class Booking extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    TextView t1,t2;
    String usern,serid;
    public GridView data;




    TextView tv;
    // String usern;
    public ListView lv;
    public String login;
    public int rowcount=0;

    private Button pickDateBtn;
    private TextView selectedDateTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        try {

        Intent ii = getIntent();
        t1 = (TextView) findViewById(R.id.textView27);
        t2 = (TextView) findViewById(R.id.textView28);

        e1 = (EditText) findViewById(R.id.editText16);
        e2 = (EditText) findViewById(R.id.editText17);
        e3 = (EditText) findViewById(R.id.editText18);
        e4 = (EditText) findViewById(R.id.editText19);



        usern = ii.getStringExtra("userid");
        serid = ii.getStringExtra("Servid");
        t1.setText(usern);
         t2.setText(serid);


        //
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


            //

            login=WebService.Viewserv(t2.getText().toString(),"Viewser");
            String[] str=login.split(",");

            if(str[0].equals("ok"))
            {
                String sid=str[1].toString();
                String sname=str[2].toString();
                String price=str[3].toString();
                String des=str[4].toString();
                e1.setText(sid);
                e2.setText(sname);
                e3.setText(price);
                e4.setText(des);

            }
            else
            {
                Toast.makeText(getApplication(),"No Data",Toast.LENGTH_SHORT).show();

            }

            //


        }

        catch (Exception e)
        {
            Toast.makeText(getApplication(),"No Data",Toast.LENGTH_SHORT).show();

        }


        //


        // on below line we are initializing our variables.
        pickDateBtn = findViewById(R.id.idBtnPickDate);
        selectedDateTV = findViewById(R.id.idTVSelectedDate);

// on below line we are adding click listener for our pick date button
        pickDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        Booking.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                selectedDateTV.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });

        //

    }


    public void goh(View arg)
    {
        Intent i = new Intent(this, Userhome.class);
        i.putExtra("userid",t1.getText().toString());
        startActivity(i);
    }

    public void Bookh(View arg)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {

            Boolean loginStatus = WebService.Bookinghere(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),selectedDateTV.getText().toString(),t1.getText().toString(), "Booking");

            Toast.makeText(this, "Added Successfully", Toast.LENGTH_LONG).show();

        }

        catch (Exception e)
        {
            Toast.makeText(this, "Exception", Toast.LENGTH_LONG).show();

        }

    }



}
