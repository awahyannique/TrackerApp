package com.example.yanniquepc.demoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ManualModeActivity extends AppCompatActivity {

    //goes to settings
    public void setting(View view){

        Intent s = new Intent(this, settings_activity.class);
        startActivity(s);

    }

    private static final String TAG = MainActivity.class.getName();

    private Button buttonKEC;
    private Button buttonLC;
    private Button buttonSEC;
    private Button buttonDO;
    private Button buttonCLC;

    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;

    //Change emailRecpt to the first name of the person you want it to go to
    //This will only be used for developement
    private String emailRecpt = "Joel"; //or Mike Jeff Awah

    //Staff Memeber Info
    private String fname;
    private String lname;
    private String empID;
    private int statusToggle=0;
    private String status;

    //Location
    private String location;

    //GET URL
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manual_mode_activity);

//////////// Get String Data from MainActivity.java and assign to variables  ///////
        fname = getIntent().getStringExtra("fname");
        lname = getIntent().getStringExtra("lname");
        empID = getIntent().getStringExtra("empID");


//////////////////////          BUTTONS         /////////////////////////////////////

        /////////////       KAPOSIA BUTTON      /////////////////////
        buttonKEC = (Button) findViewById(R.id.buttonKaposia);

        buttonKEC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
               location="Kaposia";
               checkStatus();
               sendGetRequest();

            }

        });

        /////////////         LINCOLN BUTTON     /////////////////////
        buttonLC = (Button) findViewById(R.id.buttonLincoln);

        buttonLC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
                location="Lincoln";
                checkStatus();
                sendGetRequest();

            }

        });

        /////////////         SECONDARY BUTTON    /////////////////////
        buttonSEC = (Button) findViewById(R.id.buttonSecondary);

        buttonSEC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
                location="Secondary";
                checkStatus();
                sendGetRequest();

            }

        });

        /////////////            DO BUTTON         /////////////////////
        buttonDO = (Button) findViewById(R.id.buttonDistrictOffice);

        buttonDO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
                location="District%20Office";
                checkStatus();
                sendGetRequest();

            }

        });

        /////////////             CLC BUTTON        /////////////////////
        buttonCLC = (Button) findViewById(R.id.buttonCLC);

        buttonCLC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //send GET Request
                location="CLC";
                checkStatus();
                sendGetRequest();

            }

        });
    }

    /////////////    SET STATUS TO ARRIVAL OR DEPARTURE   ///////////////
    private void checkStatus(){

        if (statusToggle == 0)
        {
            status="ARRIVAL";
            statusToggle=1;
        }
        else if (statusToggle != 0)
        {
            status="DEPARTURE";
            statusToggle=0;
        }
    }


    /////////////             SEND GET REQUEST        /////////////////////
    //php server will send email based on input from url String
    private void sendGetRequest() {

        //production url will go to front office email of location
        //url = "http://csc410.joelknutson.net/public/Email?empid="+empID+"&fname="+fname+"&lname="+lname+"&location="+location+"&status="+status+"&email="+location;
        //developement url will go to developers email based on emailRecpt
        url = "http://csc410.joelknutson.net/public/Email?empid="+empID+"&fname="+fname+"&lname="+lname+"&location="+location+"&status="+status+"&email="+emailRecpt;
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
