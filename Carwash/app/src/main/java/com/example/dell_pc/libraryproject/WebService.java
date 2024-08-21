package com.example.dell_pc.libraryproject;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebService {
	//Namespace of the Webservice - can be found in WSDL
	private static String NAMESPACE = "http://tempuri.org/";
	//Webservice URL - WSDL File location	
   // public static final String URLimgupload = "http://192.168.1.5:32768/Default.aspx";
    //public static final String URLimg = "http://192.168.1.5:32768/Images/";
	private static final String URL = "https://pccontrol.ascentz.com/Service.asmx";//Make sure you changed IP address
	//SOAP Action URI again Namespace + Web method name
	private static String SOAP_ACTION = "http://tempuri.org/";
	
	public static String invokeLoginWS(String p1,String p2,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();


		// Set Username
		unamePI.setName("Staffid");
		// Set Value
		unamePI.setValue(p1);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);

		passPI.setName("pwd");
		// Set Value
		passPI.setValue(p2);
		// Set dataType
		passPI.setType(String.class);
		// Add the property to request object
		request.addProperty(passPI);
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

	public static boolean Newuserreg(String v1,String v2,String v3,String v4,String v5,String v6, String webMethName) {
		boolean loginStatus = false;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3 = new PropertyInfo();
		PropertyInfo p4 = new PropertyInfo();
		PropertyInfo p5 = new PropertyInfo();
		PropertyInfo p6= new PropertyInfo();


		p1.setName("Userid");//dotnet webservice code string
		p1.setValue(v1);//in this code string variable
		p1.setType(String.class);
		request.addProperty(p1);

		p2.setName("Username");
		p2.setValue(v2);
		p2.setType(String.class);
		request.addProperty(p2);


		p3.setName("Pwd");
		p3.setValue(v3);
		p3.setType(String.class);
		request.addProperty(p3);

		p4.setName("Addr");
		p4.setValue(v4);
		p4.setType(String.class);
		request.addProperty(p4);

		p5.setName("Mob");
		p5.setValue(v5);
		p5.setType(String.class);
		request.addProperty(p5);

		p6.setName("Email");
		p6.setValue(v6);
		p6.setType(String.class);
		request.addProperty(p6);


		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = Boolean.parseBoolean(response.toString());

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}


	public static String Viewserv(String p1,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();


		// Set Username
		unamePI.setName("Servid");
		// Set Value
		unamePI.setValue(p1);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);


		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}


	public static String Ordersdet(String v1, String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();


		p1.setName("res");//dotnet webservice code string
		p1.setValue(v1);//in this code string variable
		p1.setType(String.class);
		request.addProperty(p1);





		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}


	public static boolean cancelbooking(String v1, String webMethName) {
		boolean loginStatus = false;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();




		p1.setName("Bid");//dotnet webservice code string
		p1.setValue(v1);//in this code string variable
		p1.setType(String.class);
		request.addProperty(p1);






		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = Boolean.parseBoolean(response.toString());

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

	public static boolean updatereq(String v1,String v2, String webMethName) {
		boolean loginStatus = false;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();


		p1.setName("reqid");//dotnet webservice code string
		p1.setValue(v1);//in this code string variable
		p1.setType(String.class);
		request.addProperty(p1);

		p2.setName("repl");
		p2.setValue(v2);
		p2.setType(String.class);
		request.addProperty(p2);


		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = Boolean.parseBoolean(response.toString());

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}


	public static String vstatus(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();


		// Set Username
		unamePI.setName("res");
		// Set Value
		unamePI.setValue(username);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);

		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

	public static String vpay(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();


		// Set Username
		unamePI.setName("res");
		// Set Value
		unamePI.setValue(username);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);

		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

	public static String Viewbbokingad(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();


		// Set Username
		unamePI.setName("res");
		// Set Value
		unamePI.setValue(username);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);

		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

	public static String Viewusers(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();


		// Set Username
		unamePI.setName("res");
		// Set Value
		unamePI.setValue(username);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);

		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}


	public static String Vieworders(String username,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();



		// Set Username
		unamePI.setName("res");
		// Set Value
		unamePI.setValue(username);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);

		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

	public static boolean Newusers(String v1,String v2,String v3,String v4,String v5,String v6, String webMethName) {
		boolean loginStatus = false;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3 = new PropertyInfo();
		PropertyInfo p4 = new PropertyInfo();
		PropertyInfo p5 = new PropertyInfo();
		PropertyInfo p6= new PropertyInfo();


		p1.setName("Userid");//dotnet webservice code string
		p1.setValue(v1);//in this code string variable
		p1.setType(String.class);
		request.addProperty(p1);

		p2.setName("Username");
		p2.setValue(v2);
		p2.setType(String.class);
		request.addProperty(p2);


		p3.setName("Pwd");
		p3.setValue(v3);
		p3.setType(String.class);
		request.addProperty(p3);

		p4.setName("Addr");
		p4.setValue(v4);
		p4.setType(String.class);
		request.addProperty(p4);

		p5.setName("Mob");
		p5.setValue(v5);
		p5.setType(String.class);
		request.addProperty(p5);

		p6.setName("Email");
		p6.setValue(v6);
		p6.setType(String.class);
		request.addProperty(p6);


		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = Boolean.parseBoolean(response.toString());

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

	public static boolean Addtocart(String v1,String v2,String v3,String v4,String v5,String v6,String v7,String v8, String webMethName) {
		boolean loginStatus = false;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3 = new PropertyInfo();
		PropertyInfo p4 = new PropertyInfo();
		PropertyInfo p5 = new PropertyInfo();
		PropertyInfo p6= new PropertyInfo();
		PropertyInfo p7= new PropertyInfo();
		PropertyInfo p8= new PropertyInfo();

		p1.setName("Iid");//dotnet webservice code string
		p1.setValue(v1);//in this code string variable
		p1.setType(String.class);
		request.addProperty(p1);

		p2.setName("Itemname");
		p2.setValue(v2);
		p2.setType(String.class);
		request.addProperty(p2);


		p3.setName("Category");
		p3.setValue(v3);
		p3.setType(String.class);
		request.addProperty(p3);

		p4.setName("Price");
		p4.setValue(v4);
		p4.setType(String.class);
		request.addProperty(p4);

		p5.setName("Qty");
		p5.setValue(v5);
		p5.setType(String.class);
		request.addProperty(p5);

		p6.setName("Total");
		p6.setValue(v6);
		p6.setType(String.class);
		request.addProperty(p6);

		p7.setName("Bakersid");
		p7.setValue(v7);
		p7.setType(String.class);
		request.addProperty(p7);


		p8.setName("Userid");
		p8.setValue(v8);
		p8.setType(String.class);
		request.addProperty(p8);


		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = Boolean.parseBoolean(response.toString());

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

	public static String Viewtot(String p1,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();


		// Set Username
		unamePI.setName("res");
		// Set Value
		unamePI.setValue(p1);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);


		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

    public static String Deletecart(String p1,String webMethName) {
        String loginStatus ="";
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        // Property which holds input parameters
        PropertyInfo unamePI = new PropertyInfo();
        PropertyInfo passPI = new PropertyInfo();


        // Set Username
        unamePI.setName("res");
        // Set Value
        unamePI.setValue(p1);
        // Set dataType
        unamePI.setType(String.class);
        // Add the property to request object
        request.addProperty(unamePI);


        // Create envelope
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        // Set output SOAP object
        envelope.setOutputSoapObject(request);
        // Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            // Invoke web service
            androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
            // Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            // Assign it to  boolean variable variable
            loginStatus = response.toString();

        } catch (Exception e) {
            //Assign Error Status true in static variable 'errored'

            e.printStackTrace();
        }
        //Return booleam to calling object
        return loginStatus;
    }


	public static boolean Addservice(String v1,String v2,String v3, String webMethName) {
		boolean loginStatus = false;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3 = new PropertyInfo();


		p1.setName("Servicename");//dotnet webservice code string
		p1.setValue(v1);//in this code string variable
		p1.setType(String.class);
		request.addProperty(p1);


		p2.setName("Price");//dotnet webservice code string
		p2.setValue(v2);//in this code string variable
		p2.setType(String.class);
		request.addProperty(p2);



		p3.setName("Description");//dotnet webservice code string
		p3.setValue(v3);//in this code string variable
		p3.setType(String.class);
		request.addProperty(p3);



		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = Boolean.parseBoolean(response.toString());

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}


    public static boolean Bookinghere(String v1,String v2,String v3,String v4,String v5,String v6, String webMethName) {
        boolean loginStatus = false;
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        // Property which holds input parameters
        PropertyInfo p1 = new PropertyInfo();
        PropertyInfo p2 = new PropertyInfo();
        PropertyInfo p3 = new PropertyInfo();
        PropertyInfo p4 = new PropertyInfo();
        PropertyInfo p5 = new PropertyInfo();
		PropertyInfo p6 = new PropertyInfo();


        p1.setName("Sid");//dotnet webservice code string
        p1.setValue(v1);//in this code string variable
        p1.setType(String.class);
        request.addProperty(p1);


        p2.setName("Servicename");//dotnet webservice code string
        p2.setValue(v2);//in this code string variable
        p2.setType(String.class);
        request.addProperty(p2);



        p3.setName("Price");//dotnet webservice code string
        p3.setValue(v3);//in this code string variable
        p3.setType(String.class);
        request.addProperty(p3);

        p4.setName("Description");//dotnet webservice code string
        p4.setValue(v4);//in this code string variable
        p4.setType(String.class);
        request.addProperty(p4);

        p5.setName("Bdate");//dotnet webservice code string
        p5.setValue(v5);//in this code string variable
        p5.setType(String.class);
        request.addProperty(p5);

		p6.setName("Userid");//dotnet webservice code string
		p6.setValue(v6);//in this code string variable
		p6.setType(String.class);
		request.addProperty(p6);

        // Create envelope
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        // Set output SOAP object
        envelope.setOutputSoapObject(request);
        // Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            // Invoke web service
            androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
            // Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            // Assign it to  boolean variable variable
            loginStatus = Boolean.parseBoolean(response.toString());

        } catch (Exception e) {
            //Assign Error Status true in static variable 'errored'

            e.printStackTrace();
        }
        //Return booleam to calling object
        return loginStatus;
    }


	public static boolean Additems(String v1,String v2,String v3,String v4, String webMethName) {
		boolean loginStatus = false;
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();
		PropertyInfo p3 = new PropertyInfo();
		PropertyInfo p4 = new PropertyInfo();

		p1.setName("Iname");//dotnet webservice code string
		p1.setValue(v1);//in this code string variable
		p1.setType(String.class);
		request.addProperty(p1);

		p2.setName("Category");//dotnet webservice code string
		p2.setValue(v2);//in this code string variable
		p2.setType(String.class);
		request.addProperty(p2);


		p3.setName("Price");//dotnet webservice code string
		p3.setValue(v3);//in this code string variable
		p3.setType(String.class);
		request.addProperty(p3);

		p4.setName("Bakersid");//dotnet webservice code string
		p4.setValue(v4);//in this code string variable
		p4.setType(String.class);
		request.addProperty(p4);

		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = Boolean.parseBoolean(response.toString());

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}

	public static String Viewservice(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();


		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);



		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}

	public static String Viewserviceadmin(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();


		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);



		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}


	public static String Viewbook(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();


		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);



		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}

	public static String Viewitem1(String v1,String v2, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo p1 = new PropertyInfo();
		PropertyInfo p2 = new PropertyInfo();

		p1.setName("bakery");
		p1.setValue(v1);
		p1.setType(String.class);
		request.addProperty(p1);

		p2.setName("cate");
		p2.setValue(v2);
		p2.setType(String.class);
		request.addProperty(p2);



		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}


	public static String viewreq(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();


		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);



		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}


	public static String Viewbillall(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();


		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);



		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}

	public static String bookhere(String p1,String p2,String p3,String webMethName) {
		String loginStatus ="";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		PropertyInfo passPI = new PropertyInfo();
		PropertyInfo v3 = new PropertyInfo();

		// Set Username
		unamePI.setName("Requser");
		// Set Value
		unamePI.setValue(p1);
		// Set dataType
		unamePI.setType(String.class);
		// Add the property to request object
		request.addProperty(unamePI);

		passPI.setName("Seekerid");
		// Set Value
		passPI.setValue(p2);
		// Set dataType
		passPI.setType(String.class);
		// Add the property to request object
		request.addProperty(passPI);

		v3.setName("Jobdesc");
		// Set Value
		v3.setValue(p3);
		// Set dataType
		v3.setType(String.class);
		// Add the property to request object
		request.addProperty(v3);
		// Create envelope
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			loginStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return loginStatus;
	}


	public static String searchhere(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();


		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);



		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}


	public static String Viewpay(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();


		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);



		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}

	public static String viewair(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}


	public static String viewdriver(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}

	public static boolean stup(String pwd,String sreg,String webMethName) {
        boolean loginStatus = false;
        // Create request
        SoapObject request = new SoapObject(NAMESPACE, webMethName);
        // Property which holds input parameters
        PropertyInfo p1 = new PropertyInfo();
        PropertyInfo p2 = new PropertyInfo();

        p1.setName("res");//dotnet webservice code string
        p1.setValue(pwd);//in this code string variable
        p1.setType(String.class);
        request.addProperty(p1);

        p2.setName("sid");
        p2.setValue(sreg);
        p2.setType(String.class);
        request.addProperty(p2);


        // Create envelope
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        // Set output SOAP object
        envelope.setOutputSoapObject(request);
        // Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            // Invoke web service
            androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
            // Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            // Assign it to  boolean variable variable
            loginStatus = Boolean.parseBoolean(response.toString());

        } catch (Exception e) {
            //Assign Error Status true in static variable 'errored'

            e.printStackTrace();
        }
        //Return booleam to calling object
        return loginStatus;
    }


	public static String Viewcate(String FuName, String webMethName) {
		String viewStatus = "";
		// Create request
		SoapObject request = new SoapObject(NAMESPACE, webMethName);
		// Property which holds input parameters
		PropertyInfo unamePI = new PropertyInfo();
		unamePI.setName("res");
		unamePI.setValue(FuName);
		unamePI.setType(String.class);
		request.addProperty(unamePI);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		// Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			// Invoke web service
			androidHttpTransport.call(SOAP_ACTION+webMethName, envelope);
			// Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			// Assign it to  boolean variable variable
			viewStatus = response.toString();

		} catch (Exception e) {
			//Assign Error Status true in static variable 'errored'

			e.printStackTrace();
		}
		//Return booleam to calling object
		return viewStatus;
	}

}
