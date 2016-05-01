package com.example.android.myhealth;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 4/12/2016.
 */
public class retrieve_activity extends FragmentActivity {
Button b1;
    int pid;
    String sql1;
    SQLiteDatabase db;
    String db_name="jeff";

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    String ppid;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve);
        Intent i=getIntent();
         pid=i.getIntExtra("text",0);
        // Toast.makeText(getApplicationContext(),Integer.toString(pid),Toast.LENGTH_LONG).show();

        db=openOrCreateDatabase(db_name,MODE_PRIVATE,null);



        b1 = (Button) findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.LinearLayout01);

        e2=(EditText)findViewById(R.id.ET2);

        e3=(EditText)findViewById(R.id.ET3);

        e4=(EditText)findViewById(R.id.ET4);

        e5=(EditText)findViewById(R.id.ET5);

        e6=(EditText)findViewById(R.id.ET6);

        e7=(EditText)findViewById(R.id.ET7);
        e8=(EditText)findViewById(R.id.ET8);

        e9=(EditText)findViewById(R.id.ET9);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = e1.getText().toString();
                DateFormat formatter =new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);
                try {
                    Date date=formatter.parse(st);
                } catch (ParseException e) {
                    //If input date is in different format or invalid.
                    Toast.makeText(getApplicationContext(), "Please enter correct format of date", Toast.LENGTH_LONG).show();
                    return;
                }

                String[] parts = st.split("/");
                String foo1 = parts[0];
                String foo2 = parts[1];
                String foo3 = parts[2];
               // int day = Integer.parseInt(foo1);
               // int month = Integer.parseInt(foo2);

               // int year = Integer.parseInt(foo3);


                // Toast.makeText(getApplicationContext(), day + "," + month + "," + year, Toast.LENGTH_LONG).show();

                ppid=Integer.toString(pid);

                Cursor c=db.rawQuery("SELECT * FROM Patient2 WHERE pid = ? AND day= ? AND month=? AND year=?", new String[]{ppid, foo1, foo2, foo3});
        int pointer=0;
                String s4;
                c.moveToFirst();
                do {
                     s4 = c.getString(4);
                    e2.setText(s4);
                    s4 = c.getString(5);
                    e3.setText(s4);
                    s4 = c.getString(6);
                    e4.setText(s4);
                    s4 = c.getString(7);
                    e5.setText(s4);
                    s4 = c.getString(8);
                    e6.setText(s4);
                    s4 = c.getString(9);
                    e7.setText(s4);
                    s4 = c.getString(10);
                    e8.setText(s4);
                    s4 = c.getString(11);
                    e9.setText(s4);
                    //Toast.makeText(getApplicationContext(), s4, Toast.LENGTH_LONG).show();

                }while(c.moveToNext());


            }
        });

    }

}
