package com.example.yanniquepc.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;


public class settings_activity extends AppCompatActivity {

    //Staff Member Info
    private String fname;
    private String lname;
    private String empID;

    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;

    private TextView TextViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

//////////// Get String Data from MainActivity.java and assign to variables  ///////
        fname = getIntent().getStringExtra("fname");
        lname = getIntent().getStringExtra("lname");
        empID = getIntent().getStringExtra("empID");

        //Set text box entry to empID
        TextViewStatus = (TextView) findViewById(R.id.employeeName_editText);
        TextViewStatus.setText(fname + " " + lname);

        TextViewStatus = (TextView) findViewById(R.id.employeeId_editText);
        TextViewStatus.setText(empID);


    }

}


