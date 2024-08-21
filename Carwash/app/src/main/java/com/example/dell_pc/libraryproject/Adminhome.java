package com.example.dell_pc.libraryproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Adminhome extends AppCompatActivity {

    public String login;
    public String[] arr1= new String[41];
    public String[] arr2= new String[41];
    public String[] arr3= new String[41];
    public String[] arr4= new String[41];
    public String[] arr5= new String[41];
    public String[] arr6= new String[41];
    public String[] arr7= new String[41];
    public String[] arr8= new String[41];
    public int rowcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);
    }

    public void gotocate(View arg)
    {
        Intent i = new Intent(this, Addcategory.class);
        startActivity(i);
    }

    public void gotolog(View arg)
    {
        Intent i = new Intent(this, Loginmain.class);
        startActivity(i);
    }

    public void Vordera(View arg)
    {

        try{
            if (android.os.Build.VERSION.SDK_INT >= 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }

            login=WebService.Viewbbokingad("Hello","Viewbooking");


            String[] listss= login.split("#");
            int xx= listss.length;

            int iRows = listss.length;
            rowcount=iRows;

            arr1 = new String[iRows];
            arr2 = new String[iRows];
            arr3 = new String[iRows];
            arr4= new String[iRows];
            arr5= new String[iRows];
            arr6= new String[iRows];
            arr7= new String[iRows];
            arr8= new String[iRows];
            StringBuffer buffer=new StringBuffer();
            int i=0;
            // looping through all rows and adding to list
            for (i=0;i<listss.length;i++) {
                String[] ListItems = listss[i].toString().split(",");
                buffer.append("Booking id: " + ListItems[0].toString()+"\n");
                buffer.append("Service id: "+ListItems[1].toString()+"\n");
                buffer.append("Service: "+ListItems[2].toString()+"\n");
                buffer.append("Price: "+ListItems[3].toString()+"\n");
                buffer.append("Description: "+ListItems[4].toString()+"\n");
                buffer.append("Date: "+ListItems[5].toString()+"\n");
                buffer.append("Userid: "+ListItems[6].toString()+"\n");
                buffer.append("Status: "+ListItems[7].toString()+"\n");
                buffer.append("\n");

            }


            showMessage("Booking Details", buffer.toString());

        }
        catch(Exception e){

            Toast.makeText(getApplicationContext(), "No Record",Toast.LENGTH_SHORT).show();
        }

//

    }


    public void Vitm(View arg)
    {

//
        Intent i = new Intent(this, Viewitems.class);
        startActivity(i);

//
    }

    public void Vusers(View arg)
    {

//
        try{
            if (android.os.Build.VERSION.SDK_INT >= 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }

            login=WebService.Viewusers("Hello","vusersdet");


            String[] listss= login.split("#");
            int xx= listss.length;

            int iRows = listss.length;
            rowcount=iRows;

            arr1 = new String[iRows];
            arr2 = new String[iRows];
            arr3 = new String[iRows];
            arr4= new String[iRows];
            arr5= new String[iRows];
            //    arr6= new String[iRows];
            //   arr7= new String[iRows];
            //  arr8= new String[iRows];
            StringBuffer buffer=new StringBuffer();
            int i=0;
            // looping through all rows and adding to list
            for (i=0;i<listss.length;i++) {
                String[] ListItems = listss[i].toString().split(",");
                buffer.append("User id: " + ListItems[0].toString()+"\n");
                buffer.append("Name: "+ListItems[1].toString()+"\n");
                buffer.append("Address: "+ListItems[2].toString()+"\n");
                buffer.append("Mobile: "+ListItems[3].toString()+"\n");
                buffer.append("Email: "+ListItems[4].toString()+"\n");
                //  buffer.append("Status: "+ListItems[5].toString()+"\n");
                // buffer.append("Reply: "+ListItems[6].toString()+"\n");
                //  buffer.append("Description: "+ListItems[7].toString()+"\n");
                buffer.append("\n");

            }


            showMessage("User Details", buffer.toString());

        }
        catch(Exception e){

            Toast.makeText(getApplicationContext(), "No Record",Toast.LENGTH_SHORT).show();
        }

//
    }


    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
