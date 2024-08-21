package com.example.dell_pc.libraryproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import android.widget.ListView;


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

public class Viewordersdet extends AppCompatActivity {
    EditText e1;
    TextView t1,t2;
    String usern,oid,dept,syear;



    public GridView data;
    public String[] id= new String[41];
    public String[] odate= new String[41];
    public String[] uid= new String[41];
    public String[] uname= new String[41];
    public String[] addr= new String[41];
    public String[] Mob= new String[41];
    public String[] Tot= new String[41];
    public String[] Status= new String[41];
    public String[] iid= new String[41];
    public String[] iname= new String[41];
    public String[] Cate= new String[41];
    public String[] price= new String[41];
    public String[] Qty= new String[41];
    public String[] amt= new String[41];

    TextView tv;
    // String usern;
    public ListView lv;
    public String login;
    public int rowcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ordersdet);

        Intent ii = getIntent();
        t2 = (TextView) findViewById(R.id.textView14);
        t1 = (TextView) findViewById(R.id.textView17);

        oid = ii.getStringExtra("oid");
        usern = ii.getStringExtra("userid");
        t1.setText(usern);
        t2.setText(oid);

        //

        lv = (ListView) findViewById(R.id.listView1);

        //
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        login=WebService.Viewbillall(t2.getText().toString(),"Viewordersall");

        // Toast.makeText(getApplication(),login,Toast.LENGTH_LONG).show();
        String[] listss= login.split("#");
        int xx= listss.length;

        int iRows = listss.length;
        rowcount=iRows;

        id = new String[iRows];
        odate = new String[iRows];
        uid = new String[iRows];
        uname = new String[iRows];
        addr = new String[iRows];
        Mob = new String[iRows];
        Tot = new String[iRows];
        Status = new String[iRows];
        iid = new String[iRows];
        iname = new String[iRows];
        Cate = new String[iRows];
        price = new String[iRows];
        Qty = new String[iRows];
        amt = new String[iRows];



        int i=0;
        // looping through all rows and adding to list
        for (i=0;i<listss.length;i++) {
            String[] ListItems = listss[i].toString().split(",");

            id[i]=ListItems[0].toString();
            odate[i]=ListItems[1].toString();
            uid[i]=ListItems[2].toString();
            uname[i]=ListItems[3].toString();
            addr[i]=ListItems[4].toString();
            Mob[i]=ListItems[5].toString();
            Tot[i]=ListItems[6].toString();
            Status[i]=ListItems[7].toString();
            iid[i]=ListItems[8].toString();
            iname[i]=ListItems[9].toString();
            Cate[i]=ListItems[10].toString();
            price[i]=ListItems[11].toString();
            Qty[i]=ListItems[12].toString();
            amt[i]=ListItems[13].toString();


            //	i++;
        }
        lv.setAdapter(new ImageAdapter(getApplicationContext()));



        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView orid=(TextView) view.findViewById(R.id.p1);
             //   TextView bagname=(TextView) view.findViewById(R.id.p2);
               // TextView addr=(TextView) view.findViewById(R.id.p3);
               // TextView mob=(TextView) view.findViewById(R.id.p4);
              //  TextView email=(TextView) view.findViewById(R.id.p5);
                // String url =WebService.URLimg +imgpath[position];

                //	Toast.makeText(UserHome.this,tv.getText(), Toast.LENGTH_LONG).show();
                Intent ij = new Intent(Viewordersdet.this, Updatestatus.class);
                ij.putExtra("oid",orid.getText());

                ij.putExtra("userid",t1.getText().toString());

                startActivityForResult(ij,500);
            }
        });


        //


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
        private TextView tv7;
        private TextView tv8;
        private TextView tv9;
        private TextView tv10;
        private TextView tv11;
        private TextView tv12;
        private TextView tv13;
        private TextView tv14;
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
            ViewGroup onerow = (ViewGroup) layoutInflater.inflate(R.layout.customorders, null);

            tv1 = (TextView) onerow.findViewById(R.id.p1);
            tv2 = (TextView) onerow.findViewById(R.id.p2);
            tv3 = (TextView) onerow.findViewById(R.id.p3);
            tv4 = (TextView) onerow.findViewById(R.id.p4);
            tv5 = (TextView) onerow.findViewById(R.id.p5);
            tv6 = (TextView) onerow.findViewById(R.id.p6);
            tv7 = (TextView) onerow.findViewById(R.id.p7);
            tv8 = (TextView) onerow.findViewById(R.id.p8);
            tv9 = (TextView) onerow.findViewById(R.id.p9);
            tv10 = (TextView) onerow.findViewById(R.id.p10);
            tv11 = (TextView) onerow.findViewById(R.id.p11);
            tv12 = (TextView) onerow.findViewById(R.id.p12);
            tv13 = (TextView) onerow.findViewById(R.id.p13);
            tv14 = (TextView) onerow.findViewById(R.id.p14);



            tv1.setText(id[position]);
            tv2.setText(odate[position]);
            tv3.setText(uid[position]);
            tv4.setText(uname[position]);
            tv5.setText(addr[position]);
            tv6.setText(Mob[position]);
            tv7.setText(Tot[position]);
            tv8.setText(Status[position]);
            tv9.setText(iid[position]);
            tv10.setText(iname[position]);
            tv11.setText(Cate[position]);
            tv12.setText(price[position]);
            tv13.setText(Qty[position]);
            tv14.setText(amt[position]);

            //position++;
            return onerow;
        }
    }







    //
}
