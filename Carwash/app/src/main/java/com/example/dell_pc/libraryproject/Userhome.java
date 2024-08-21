package com.example.dell_pc.libraryproject;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog.Builder;

public class Userhome extends AppCompatActivity {

    EditText e1;
    TextView t1,t2;
    String usern,sname;
    public GridView data;

    TextView tv;

    public String login;
    public String[] arr1= new String[41];
    public String[] arr2= new String[41];
    public String[] arr3= new String[41];
    public String[] arr4= new String[41];
    public String[] arr5= new String[41];

    public String[] arr6= new String[41];
    public String[] arr7= new String[41];
 //   public String[] arr8= new String[41];
    public int rowcount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);

        Intent ii = getIntent();
       // e1 = (EditText) findViewById(R.id.editText3);
        t1 = (TextView) findViewById(R.id.textView3);


        //t4 = (TextView) findViewById(R.id.textView6);
        usern = ii.getStringExtra("userid");
        sname = ii.getStringExtra("ufname");
          t1.setText(usern);
       // t2.setText(sname);


    }



    public void Vbak(View arg)
    {
        Intent i = new Intent(Userhome.this, Viewservice.class);
        i.putExtra("userid",t1.getText().toString());
        startActivity(i);
    }






    public void Vserreq(View arg)
    {

//
        try{
            if (android.os.Build.VERSION.SDK_INT >= 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }

            login=WebService.vstatus(usern,"vstatus");


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
          //  arr8= new String[iRows];
            StringBuffer buffer=new StringBuffer();
            int i=0;
            // looping through all rows and adding to list
            for (i=0;i<listss.length;i++) {
                String[] ListItems = listss[i].toString().split(",");
                buffer.append("Id: " + ListItems[0].toString()+"\n");
                buffer.append("Your id: "+ListItems[1].toString()+"\n");
                buffer.append("Seekere id: "+ListItems[2].toString()+"\n");
                buffer.append("Job: "+ListItems[3].toString()+"\n");
                buffer.append("Date: "+ListItems[4].toString()+"\n");
                buffer.append("Status: "+ListItems[5].toString()+"\n");
                buffer.append("Reply: "+ListItems[6].toString()+"\n");
              //  buffer.append("Description: "+ListItems[7].toString()+"\n");
                buffer.append("\n");

            }


            showMessage("My Status", buffer.toString());

        }
        catch(Exception e){

            Toast.makeText(getApplicationContext(), "No Record",Toast.LENGTH_SHORT).show();
        }

//
    }

    public void showMessage(String title,String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    public void Vcart(View arg)
    {
        Intent i = new Intent(Userhome.this, Viewcart.class);
        i.putExtra("userid",t1.getText().toString());
        startActivity(i);
    }

    public void logoutuser(View arg)
    {
        Intent i = new Intent(Userhome.this, Loginmain.class);

        startActivity(i);
    }


}
