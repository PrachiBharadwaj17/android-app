package com.example.dell_pc.libraryproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


import android.os.StrictMode;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class Viewservice extends AppCompatActivity {
    EditText e1;
    TextView t1,t2;
    String usern,servi,dept,syear;
    public GridView data;
    Spinner s1;



    public String[] Sid= new String[41];
    public String[] Servicename= new String[41];
    public String[] Price= new String[41];
    public String[] Description= new String[41];


    TextView tv;
   // String usern;
    public ListView lv;
    public String login;
    public int rowcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewservice);
try
{
        Intent ii = getIntent();
        // e1 = (EditText) findViewById(R.id.editText3);
        t1 = (TextView) findViewById(R.id.textView11);
        t2 = (TextView) findViewById(R.id.textView12);

        //t4 = (TextView) findViewById(R.id.textView6);
        usern = ii.getStringExtra("userid");
       // servi = ii.getStringExtra("servicesel");
        t1.setText(usern);
       // t2.setText(servi);

        //

        lv = (ListView) findViewById(R.id.listView1);

        //
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        login=WebService.Viewservice("Hello","selectservice");

        // Toast.makeText(getApplication(),login,Toast.LENGTH_LONG).show();
        String[] listss= login.split("#");
        int xx= listss.length;

        int iRows = listss.length;
        rowcount=iRows;

    Sid = new String[iRows];
    Servicename = new String[iRows];
    Price = new String[iRows];
    Description = new String[iRows];



        int i=0;
        // looping through all rows and adding to list
        for (i=0;i<listss.length;i++) {
            String[] ListItems = listss[i].toString().split(",");

            Sid[i]=ListItems[0].toString();
            Servicename[i]=ListItems[1].toString();
            Price[i]=ListItems[2].toString();
            Description[i]=ListItems[3].toString();


            //	i++;
        }
        lv.setAdapter(new ImageAdapter(getApplicationContext()));



        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView bugid=(TextView) view.findViewById(R.id.p1);
                TextView bagname=(TextView) view.findViewById(R.id.p2);
                TextView price=(TextView) view.findViewById(R.id.p3);
                TextView Mobile=(TextView) view.findViewById(R.id.p4);


                Intent ij = new Intent(Viewservice.this, Booking.class);
                ij.putExtra("Servid",bugid.getText());

                ij.putExtra("userid",t1.getText().toString());

                startActivityForResult(ij,500);
            }
        });


        //
}

catch (Exception e)
{
    Toast.makeText(getApplication(),"No Data",Toast.LENGTH_SHORT).show();

}

    }

    //

    private class ImageAdapter extends BaseAdapter
    {
        private Context ctx;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private TextView tv4;
        private TextView tv5;
        private TextView tv6;
        private ImageView image;
        private TextView tv7;
        private TextView tv8;
        private LayoutInflater layoutInflater;

        public ImageAdapter(Context context)
        {
            this.ctx= context;
            layoutInflater = (LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE);

        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return rowcount;
        }
        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }
        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewGroup onerow = (ViewGroup) layoutInflater.inflate(R.layout.customservice, null);

            tv1 = (TextView) onerow.findViewById(R.id.p1);
            tv2 = (TextView) onerow.findViewById(R.id.p2);
            tv3 = (TextView) onerow.findViewById(R.id.p3);
            tv4 = (TextView) onerow.findViewById(R.id.p4);

         //   URL url;






            tv1.setText(Sid[position]);
            tv2.setText(Servicename[position]);
            tv3.setText(Price[position]);
            tv4.setText(Description[position]);

            //position++;
            return onerow;
        }
    }



    //



}
