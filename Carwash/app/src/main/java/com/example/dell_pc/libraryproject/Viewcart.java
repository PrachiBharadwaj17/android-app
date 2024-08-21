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
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class Viewcart extends AppCompatActivity {
    EditText e1;
    TextView t1,t2;
    String usern,tot;
    public String login,login1;
    public GridView data;

    public String[] Bid= new String[41];
    public String[] Sid= new String[41];
    public String[] Sname= new String[41];
    public String[] Price= new String[41];
    public String[] Desc= new String[41];
    public String[] Bdate= new String[41];
    public String[] Userid= new String[41];
    public String[] Status= new String[41];


    TextView tv;
    // String usern;
    public ListView lv;
   // public String login;
    public int rowcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcart);
        try {

  Intent ii = getIntent();
        // e1 = (EditText) findViewById(R.id.editText3);
        t1 = (TextView) findViewById(R.id.textView3);


        //t4 = (TextView) findViewById(R.id.textView6);
        usern = ii.getStringExtra("userid");
        t1.setText(usern);



        //

        //

        lv = (ListView) findViewById(R.id.listView1);

        //
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        login=WebService.Viewbook(t1.getText().toString(),"Viewbook");

        // Toast.makeText(getApplication(),login,Toast.LENGTH_LONG).show();
        String[] listss= login.split("#");
        int xx= listss.length;

        int iRows = listss.length;
        rowcount=iRows;

            Bid = new String[iRows];
            Sid = new String[iRows];
            Sname = new String[iRows];
            Price = new String[iRows];
            Desc = new String[iRows];
            Bdate = new String[iRows];
            Userid = new String[iRows];
            Status = new String[iRows];




        int i=0;
        // looping through all rows and adding to list
        for (i=0;i<listss.length;i++) {
            String[] ListItems = listss[i].toString().split(",");

            Bid[i]=ListItems[0].toString();
            Sid[i]=ListItems[1].toString();
            Sname[i]=ListItems[2].toString();
            Price[i]=ListItems[3].toString();
            Desc[i]=ListItems[4].toString();
            Bdate[i]=ListItems[5].toString();
            Userid[i]=ListItems[6].toString();
            Status[i]=ListItems[7].toString();

            //	i++;
        }
        lv.setAdapter(new Viewcart.ImageAdapter(getApplicationContext()));



     lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView Cid=(TextView) view.findViewById(R.id.p1);
                TextView Iid=(TextView) view.findViewById(R.id.p2);
                TextView Iname=(TextView) view.findViewById(R.id.p3);
                TextView Cate=(TextView) view.findViewById(R.id.p4);
                TextView Price=(TextView) view.findViewById(R.id.p5);
                TextView Qty=(TextView) view.findViewById(R.id.p6);
                TextView Total=(TextView) view.findViewById(R.id.p7);
                TextView Bakersid=(TextView) view.findViewById(R.id.p8);
                // String url =WebService.URLimg +imgpath[position];

                //	Toast.makeText(UserHome.this,tv.getText(), Toast.LENGTH_LONG).show();
                Intent ij = new Intent(Viewcart.this, Bookingupdate.class);
                ij.putExtra("Bid",Cid.getText());

                //
               // login1=WebService.Deletecart(Cid.getText().toString(),"Deletecart");
               // String[] str1=login1.split(",");

               // if(str1[0].equals("ok"))
               // {
              //      Toast.makeText(getApplication(),"Deleted",Toast.LENGTH_SHORT).show();

              //  }
              //  else
              //  {
                //    Toast.makeText(getApplication(),"No Data",Toast.LENGTH_SHORT).show();

              //  }

                //

              //  ij.putExtra("Iname",itemname.getText());
               // ij.putExtra("cate",cate.getText());
               // ij.putExtra("Price",Price.getText());
               // ij.putExtra("Bakerisid",Bakerisid.getText());
                ij.putExtra("userid",t1.getText().toString());
                // ij.putExtra("url",url);
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
        //private ImageView image;
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
            ViewGroup onerow = (ViewGroup) layoutInflater.inflate(R.layout.customreq, null);

            tv1 = (TextView) onerow.findViewById(R.id.p1);
            tv2 = (TextView) onerow.findViewById(R.id.p2);
            tv3 = (TextView) onerow.findViewById(R.id.p3);
            tv4 = (TextView) onerow.findViewById(R.id.p4);
            tv5 = (TextView) onerow.findViewById(R.id.p5);
            tv6 = (TextView) onerow.findViewById(R.id.p6);
            tv7 = (TextView) onerow.findViewById(R.id.p7);
            tv8 = (TextView) onerow.findViewById(R.id.p8);

            //   URL url;






            tv1.setText(Bid[position]);
            tv2.setText(Sid[position]);
            tv3.setText(Sname[position]);
            tv4.setText(Price[position]);
            tv5.setText(Desc[position]);
            tv6.setText(Bdate[position]);
            tv7.setText(Userid[position]);
            tv8.setText(Status[position]);

            //position++;
            return onerow;
        }
    }



    //




}
