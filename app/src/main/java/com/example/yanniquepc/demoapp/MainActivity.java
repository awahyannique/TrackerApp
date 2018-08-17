package com.example.yanniquepc.demoapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    public void logIn() {



        Intent i = new Intent(MainActivity.this, ManualModeActivity.class);
        i.putExtra("name" , name);
        startActivity(i);


       /* if(employeeIDEditText.getText().toString() == ""){
            Toast.makeText(MainActivity.this, "Invalid Employee ID", Toast.LENGTH_SHORT).show();
        } else {

        }*/

    }

    private static final String TAG = MainActivity.class.getName();

    private Button buttonLogin;
    private String empID;
    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;
    public String name = null;

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////////////   LOGIN BUTTON   /////////////////////
        buttonLogin = (Button) findViewById(R.id.logIn_button);

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Set text box entry to empID
                EditText employeeIDEditText = (EditText) findViewById(R.id.employeeId_editText);
                empID = employeeIDEditText.getText().toString();

                //send GET Request
                url = "http://csc410.joelknutson.net/return_user.php?empid=" + empID;
                sendGetRequest();

            }

        });


    }


    private void sendGetRequest() {

        mRequestQueue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.i(TAG, "Response: " + response.toString());
                name= response.toString();
                logIn();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "ERROR: " + error.toString());

            }
        });

        mRequestQueue.add(stringRequest);

    }

}


/////////////////////////////    REFERENCES    /////////////////////////////////////////////////
//  transfer variables from activity to activity
//  https://www.youtube.com/watch?v=9u6FkCCflhc
//
//
//
//
//
////////////////////////////////////////////////////////////////////////////////////////////////

/*  try{
            SQLiteDatabase employeeDatabase = this.openOrCreateDatabase("EmployeeDB", MODE_PRIVATE, null);
            employeeDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3), employeeID VARCHAR)");

            employeeDatabase.execSQL("INSERT INTO users(name, age, employeeID) VALUES('awah', 24, '4190')");

            employeeDatabase.execSQL("INSERT INTO users(name, age, employeeID) VALUES('bob', 25, '1234')");


            Cursor c = employeeDatabase.rawQuery("SELECT * FROM users", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int employeeIDIndex = c.getColumnIndex("employeeID");

            c.moveToFirst();
            while(c != null){

                Log.i("name", c.getString(nameIndex));
                Log.i("age", Integer.toString(c.getInt(ageIndex)));
                Log.i("employeeID", c.getString(employeeIDIndex));

                c.moveToNext();
            }

        } catch (Exception e){
            e.printStackTrace();
        }*/
