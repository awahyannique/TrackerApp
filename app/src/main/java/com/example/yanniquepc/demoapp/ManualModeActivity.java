package com.example.yanniquepc.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ManualModeActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private Button buttonKEC;
    private Button buttonLC;
    private Button buttonSEC;
    private Button buttonDO;
    private Button buttonCLC;

    private RequestQueue mRequestQueue;

    private StringRequest stringRequest;

    //Change emailRecpt to the first name of the person you want it to go to
    private String emailRecpt = "Joel"; //or Mike Jeff Awah
    //Staff Memeber Info
    private String fname = "Joel";
    private String lname = "Knutson";
    private String empID = "1234";

    //Location
    private String location;

    //GET URL
    private String url;
    //private  String urlKaposia = "http://csc410.joelknutson.net/public/Email?empid=1234&fname=Joel&lname=Knutson&location=Kaposia&status=ARRIVAL&email="+emailRecpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual_mode_activity);

        /////////////   KAPOSIA BUTTON   /////////////////////
        buttonKEC = (Button) findViewById(R.id.buttonKaposia);

        buttonKEC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
                location="Kaposia";
                url = "http://csc410.joelknutson.net/public/Email?empid="+empID+"&fname="+fname+"&lname="+lname+"&location="+location+"&status=ARRIVAL&email="+emailRecpt;
                sendGetRequest();

            }

        });

        /////////////   LINCOLN BUTTON   /////////////////////
        buttonLC = (Button) findViewById(R.id.buttonLincoln);

        buttonLC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
                location="Lincoln";
                url = "http://csc410.joelknutson.net/public/Email?empid="+empID+"&fname="+fname+"&lname="+lname+"&location="+location+"&status=ARRIVAL&email="+emailRecpt;
                sendGetRequest();

            }

        });

        /////////////   SECONDARY BUTTON   /////////////////////
        buttonLC = (Button) findViewById(R.id.buttonSecondary);

        buttonLC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
                location="Secondary";
                url = "http://csc410.joelknutson.net/public/Email?empid="+empID+"&fname="+fname+"&lname="+lname+"&location="+location+"&status=ARRIVAL&email="+emailRecpt;
                sendGetRequest();

            }

        });

        /////////////   DO BUTTON   /////////////////////
        buttonLC = (Button) findViewById(R.id.buttonDistrictOffice);

        buttonLC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
                location="District%20Office";
                url = "http://csc410.joelknutson.net/public/Email?empid="+empID+"&fname="+fname+"&lname="+lname+"&location="+location+"&status=ARRIVAL&email="+emailRecpt;
                sendGetRequest();

            }

        });

        /////////////   CLC BUTTON   /////////////////////
        buttonLC = (Button) findViewById(R.id.buttonCLC);

        buttonLC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
                location="CLC";
                url = "http://csc410.joelknutson.net/public/Email?empid="+empID+"&fname="+fname+"&lname="+lname+"&location="+location+"&status=ARRIVAL&email="+emailRecpt;
                sendGetRequest();

            }

        });
    }

    private void sendGetRequest() {

        mRequestQueue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.i(TAG,"Response: "+ response.toString());

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"ERROR: "+ error.toString());

            }
        });

        mRequestQueue.add(stringRequest);

    }
}
