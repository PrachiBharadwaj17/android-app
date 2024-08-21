package com.example.dell_pc.libraryproject;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class userlogin extends AppCompatActivity {
    public String login;
    public EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
    }

    public void loginseeker(View arg)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        login=WebService.invokeLoginWS(e1.getText().toString(),e2.getText().toString(),"userlogin");
        String[] str=login.split(",");

        if(str[0].equals("ok"))
        {
            Toast.makeText(getApplication(),"Login Success",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(userlogin.this, Userhome.class);
            i.putExtra("userid",e1.getText().toString());
            i.putExtra("ufname",str[1].toString());

            startActivity(i);
        }
        else
        {
            Toast.makeText(getApplication(),"Login Failed",Toast.LENGTH_SHORT).show();
            e1.setText("");
            e2.setText("");
        }



    }


    public void newseeker(View arg)
    {
        Intent i = new Intent(userlogin.this, Userreg.class);
        startActivity(i);
    }
}
