package com.example.yanniquepc.demoapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void logIn(View view){

        EditText employeeIDEditText = (EditText) findViewById(R.id.employeeId_editText);

        Intent i = new Intent(this, ManualModeActivity.class);
        startActivity(i);

       /* if(employeeIDEditText.getText().toString() == ""){
            Toast.makeText(MainActivity.this, "Invalid Employee ID", Toast.LENGTH_SHORT).show();
        } else {

        }*/

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }


}
