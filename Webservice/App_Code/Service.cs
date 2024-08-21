using System;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.Xml.Linq;
using System.Data.SqlClient;
using System.IO;
using System.Data;
using System.Net;
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class Service : System.Web.Services.WebService
{
    SqlConnection con = new SqlConnection("server=.\\sqlexpress;database=Carwash;Integrated security=true;");
    SqlCommand cmd;
    String Cdate;
    string uname; 
    string addr;
    string mob, ordermastid;
    public Service()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    [WebMethod]
    public String userlogin(String Staffid, String pwd)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();

        cmd = new SqlCommand("select * from Newuser where Userid='" + Staffid + "' and Pwd='" + pwd + "'", con);
        SqlDataReader dr = cmd.ExecuteReader();
        if (dr.Read())
        {
            s = "ok," + dr[1].ToString();
        }
        else
        {
            s = "not OK,not OK";
        }
        dr.Close();
        return s;
    }


    
    [WebMethod]
    public Boolean Newuser(String Userid, String Username, String Pwd, String Addr, String Mob, String Email)
    {
        Boolean boolResult = false;

        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("insert into Newuser values('" + Userid + "','" + Username + "','" + Pwd + "','" + Addr + "','" + Mob + "','" + Email + "')", con);
        cmd.ExecuteNonQuery();
        con.Close();
        boolResult = true;
        return boolResult;
    }

    [WebMethod]
    public Boolean Addservice(String Servicename, String Price, String Description)
    {
        Boolean boolResult = false;

        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("insert into Addservice values('" + Servicename + "','" + Price + "','" + Description + "')", con);
        cmd.ExecuteNonQuery();
        con.Close();
        boolResult = true;
        return boolResult;
    }


    

    [WebMethod]
    public String selectservice(String res)
    {
        String Result = "";
        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("select * from Addservice", con);
        //cmd = new SqlCommand("select * from Attendance", con);
        SqlDataReader dr;
        dr = cmd.ExecuteReader();
        while (dr.Read())
        {
            Result += dr[0].ToString() + "," + dr[1].ToString() + "," + dr[2].ToString() + "," + dr[3].ToString() + "#";

        }
        dr.Close();
        con.Close();
        return Result;

    }


    [WebMethod]
    public String Viewser(String Servid)
    {
        String s = "";
        if (con.State == ConnectionState.Closed)
            con.Open();

        cmd = new SqlCommand("select * from Addservice where Sid='" + Servid + "'", con);
        SqlDataReader dr = cmd.ExecuteReader();
        if (dr.Read())
        {
            s = "ok," + dr[0].ToString() + "," + dr[1].ToString() + "," + dr[2].ToString() + "," + dr[3].ToString();
        }
        else
        {
            s = "not OK";
        }
        dr.Close();
        return s;
    }

    [WebMethod]
    public Boolean Booking(String Sid, String Servicename, String Price, String Description, String Bdate, String Userid)
    {
        Boolean boolResult = false;

        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("insert into Booking values('" + Sid + "','" + Servicename + "','" + Price + "','" + Description + "','" + Bdate + "','" + Userid + "','Confirmed')", con);
        cmd.ExecuteNonQuery();
        con.Close();
        boolResult = true;
        return boolResult;
    }

    [WebMethod]
    public String Viewbook(String res)
    {
        String Result = "";
        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("select * from Booking where Userid='" + res + "'", con);
        //cmd = new SqlCommand("select * from Attendance", con);
        SqlDataReader dr;
        dr = cmd.ExecuteReader();
        while (dr.Read())
        {
            Result += dr[0].ToString() + "," + dr[1].ToString() + "," + dr[2].ToString() + "," + dr[3].ToString() + "," + dr[4].ToString() + "," + dr[5].ToString() + "," + dr[6].ToString() + "," + dr[7].ToString() + "#";

        }
        dr.Close();
        con.Close();
        return Result;

    }

    [WebMethod]
    public Boolean cancelbook(String Bid)
    {
        Boolean boolResult = false;

        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("update Booking set Status='Cancel' where Bid='" + Bid + "'", con);
        cmd.ExecuteNonQuery();
        con.Close();
        boolResult = true;
        return boolResult;
    }


    [WebMethod]
    public String Viewservice(String res)
    {
        String Result = "";
        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("select * from Addservice", con);
        //cmd = new SqlCommand("select * from Attendance", con);
        SqlDataReader dr;
        dr = cmd.ExecuteReader();
        while (dr.Read())
        {
            Result += dr[0].ToString() + "," + dr[1].ToString() + "," + dr[2].ToString() + "," + dr[3].ToString() + "#";

        }
        dr.Close();
        con.Close();
        return Result;

    }

    [WebMethod]
    public String Deleteitem(String res)
    {
        String s = "";
        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("Delete from Addservice where Sid='" + res + "'", con);
        cmd.ExecuteNonQuery();
        con.Close();
        s = "ok";
        return s;
    }


    [WebMethod]
    public string Viewbooking(string res)
    {

        string Result = "";

        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("select * from Booking", con);
        SqlDataReader dr;
        dr = cmd.ExecuteReader();
        while (dr.Read())
        {
            Result += dr[0].ToString() + "," + dr[1].ToString() + "," + dr[2].ToString() + "," + dr[3].ToString() + "," + dr[4].ToString() + "," + dr[5].ToString() + "," + dr[6].ToString() + "," + dr[7].ToString() + "#";
        }
        dr.Close();
        con.Close();
        return Result;
    }


    [WebMethod]
    public string vusersdet(string res)
    {

        string Result = "";

        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("select * from Newuser", con);
        SqlDataReader dr;
        dr = cmd.ExecuteReader();
        while (dr.Read())
        {
            Result += dr[0].ToString() + "," + dr[1].ToString() + "," + dr[3].ToString() + "," + dr[4].ToString() + "," + dr[5].ToString() + "#";
        }
        dr.Close();
        con.Close();
        return Result;
    }


   


   

  

    

 
    

    
   

   

   

  

  
   

  

    
}
