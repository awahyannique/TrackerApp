package com.example.yanniquepc.demoapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    private TextView TextViewStatus;
    private TextView LocationTextView;

    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;

    //Change emailRecpt to the first name of the person you want it to go to
    //This will only be used for developement
    private String emailRecpt = "Awah"; //or Mike Jeff Awah

    //Staff Member Info
    private String fname = "Awah";
    private String lname = "Ndingwan";
    private String empID = "4190";
    private int statusToggle=0;
    private String status;

    //counter variables
    int buttonKaposiaCounter = 0;
    int buttonLincolnCounter = 0;
    int buttonSecondaryCounter = 0;
    int buttonDistrictOfficeCounter  = 0;
    int buttonCLC_Counter = 0;


    //Location
    private String location ;

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

        //text views
     //   mTextView = (TextView) findViewById(R.id.tv);
        TextViewStatus  = (TextView) findViewById(R.id.CheckedINorOut);
        LocationTextView = (TextView) findViewById(R.id.getCurrentLocation);


//////////////////////          BUTTONS         /////////////////////////////////////

        /////////////       KAPOSIA BUTTON      /////////////////////
        buttonKEC = (Button) findViewById(R.id.buttonKaposia);

        buttonKEC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonKaposiaCounter++;
                if(buttonKaposiaCounter == 1) {
                    buttonKEC.setBackgroundColor(Color.GREEN);
                    buttonLC.setEnabled(false);
                    buttonSEC.setEnabled(false);
                    buttonDO.setEnabled(false);
                    buttonCLC.setEnabled(false);

                    //send GET Request
                    location="Kaposia";
                    checkStatus();
                    sendGetRequest();
                    TextViewStatus.setText("Checked In");
                    LocationTextView.setText(location);

                } else if(buttonKaposiaCounter == 0 ||  buttonKaposiaCounter > 1) {
                    buttonKEC.setBackgroundResource(android.R.drawable.btn_default);

                    buttonLC.setEnabled(true);
                    buttonSEC.setEnabled(true);
                    buttonDO.setEnabled(true);
                    buttonCLC.setEnabled(true);

                    buttonKaposiaCounter = 0;
                    //send GET Request
                    location="Kaposia";
                    checkStatus();
                    sendGetRequest();

                    TextViewStatus.setText("Checked Out");
                    LocationTextView.setText(location);
                }

            }

        });

        /////////////         LINCOLN BUTTON     /////////////////////
        buttonLC = (Button) findViewById(R.id.buttonLincoln);

        buttonLC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonLincolnCounter++;
                if(buttonLincolnCounter == 1) {
                    buttonLC.setBackgroundColor(Color.GREEN);
                    buttonKEC.setEnabled(false);
                    buttonSEC.setEnabled(false);
                    buttonDO.setEnabled(false);
                    buttonCLC.setEnabled(false);

                    //send GET Request
                    location="Lincoln";
                    checkStatus();
                    sendGetRequest();
                    TextViewStatus.setText("Checked In");
                    LocationTextView.setText(location);

                } else if(buttonLincolnCounter == 0 ||  buttonLincolnCounter > 1) {
                    buttonLC.setBackgroundResource(android.R.drawable.btn_default);



                    buttonKEC.setEnabled(true);
                    buttonSEC.setEnabled(true);
                    buttonDO.setEnabled(true);
                    buttonCLC.setEnabled(true);

                    buttonLincolnCounter = 0;
                    //send GET Request
                    location="Lincoln";
                    checkStatus();
                    sendGetRequest();

                    TextViewStatus.setText("Checked Out");
                    LocationTextView.setText(location);

                }
            }

        });

        /////////////         SECONDARY BUTTON    /////////////////////
        buttonSEC = (Button) findViewById(R.id.buttonSecondary);

        buttonSEC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonSecondaryCounter++;
                if(buttonSecondaryCounter == 1) {
                    buttonSEC.setBackgroundColor(Color.GREEN);
                    buttonKEC.setEnabled(false);
                    buttonLC.setEnabled(false);
                    buttonDO.setEnabled(false);
                    buttonCLC.setEnabled(false);

                    //send GET Request
                    location="Secondary";
                    checkStatus();
                    sendGetRequest();
                    TextViewStatus.setText("Checked In");
                    LocationTextView.setText(location);

                } else if(buttonSecondaryCounter == 0 ||  buttonSecondaryCounter > 1) {
                    buttonSEC.setBackgroundResource(android.R.drawable.btn_default);

                    buttonKEC.setEnabled(true);
                    buttonLC.setEnabled(true);
                    buttonDO.setEnabled(true);
                    buttonCLC.setEnabled(true);

                    buttonSecondaryCounter = 0;
                    //send GET Request
                    location="Secondary";
                    checkStatus();
                    sendGetRequest();

                    TextViewStatus.setText("Checked Out");
                    LocationTextView.setText(location);

                }

            }

        });

        /////////////            DO BUTTON         /////////////////////
        buttonDO = (Button) findViewById(R.id.buttonDistrictOffice);

        buttonDO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonDistrictOfficeCounter++;
                if(buttonDistrictOfficeCounter == 1) {
                    buttonDO.setBackgroundColor(Color.GREEN);
                    buttonKEC.setEnabled(false);
                    buttonLC.setEnabled(false);
                    buttonSEC.setEnabled(false);
                    buttonCLC.setEnabled(false);

                    //send GET Request
                    location="District";
                    checkStatus();
                    sendGetRequest();
                    TextViewStatus.setText("Checked In");
                    LocationTextView.setText(location);

                } else if(buttonDistrictOfficeCounter == 0 ||  buttonDistrictOfficeCounter > 1) {
                    buttonDO.setBackgroundResource(android.R.drawable.btn_default);

                    buttonKEC.setEnabled(true);
                    buttonLC.setEnabled(true);
                    buttonSEC.setEnabled(true);
                    buttonCLC.setEnabled(true);

                    buttonDistrictOfficeCounter = 0;
                    //send GET Request
                    location="District";
                    checkStatus();
                    sendGetRequest();

                    TextViewStatus.setText("Checked Out");
                    LocationTextView.setText(location);
                }

            }

        });

        /////////////             CLC BUTTON        /////////////////////
        buttonCLC = (Button) findViewById(R.id.buttonCLC);

        buttonCLC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                buttonCLC_Counter++;
                if(buttonCLC_Counter == 1) {
                    buttonCLC.setBackgroundColor(Color.GREEN);
                    buttonKEC.setEnabled(false);
                    buttonLC.setEnabled(false);
                    buttonSEC.setEnabled(false);
                    buttonDO.setEnabled(false);

                    //send GET Request
                    location="CLC";
                    checkStatus();
                    sendGetRequest();
                    TextViewStatus.setText("Checked In");
                    LocationTextView.setText(location);

                } else if(buttonCLC_Counter == 0 ||  buttonCLC_Counter > 1) {
                    buttonCLC.setBackgroundResource(android.R.drawable.btn_default);

                    buttonKEC.setEnabled(true);
                    buttonLC.setEnabled(true);
                    buttonSEC.setEnabled(true);
                    buttonDO.setEnabled(true);

                    buttonCLC_Counter = 0;
                    //send GET Request
                    location="CLC";
                    checkStatus();
                    sendGetRequest();

                    TextViewStatus.setText("Checked Out");
                    LocationTextView.setText(location);
                }



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
