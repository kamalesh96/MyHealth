package com.example.android.myhealth;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 4/12/2016.
 */
public class activity_loginned extends FragmentActivity{
    String text1,text2,text3,text4,text5,text6,text7,text8;
    String db_name="jeff";
    String sql1;
    SQLiteDatabase db;
    int pid,count;

    EditText e1;

    Spinner spinner1;
    ArrayAdapter<CharSequence> adapter1;

    Spinner spinner2;
    ArrayAdapter<CharSequence> adapter2;

    Spinner spinner3;
    ArrayAdapter<CharSequence> adapter3;


    Spinner spinner4;
    ArrayAdapter<CharSequence> adapter4;

    Spinner spinner5;
    ArrayAdapter<CharSequence> adapter5;


    Spinner spinner6;
    ArrayAdapter<CharSequence> adapter6;


    Spinner spinner7;
    ArrayAdapter<CharSequence> adapter7;


    Spinner spinner8;
    ArrayAdapter<CharSequence> adapter8;

    Spinner spinner9;
    ArrayAdapter<CharSequence> adapter9;

    Spinner spinner10;
    ArrayAdapter<CharSequence> adapter10;

    Spinner spinner11;
    ArrayAdapter<CharSequence> adapter11;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginned);

        Intent i=getIntent();
         pid=i.getIntExtra("text",0);
      // Toast.makeText(getApplicationContext(),Integer.toString(pid),Toast.LENGTH_LONG).show();


        e1=(EditText)findViewById(R.id.date_button);

        Button button2=(Button)findViewById(R.id.Button1);


        db=openOrCreateDatabase(db_name,MODE_PRIVATE,null);
        sql1="create table if not exists Patient2(pid varchar ,day varchar,month varchar,year varchar,hemat varchar,hemog varchar,ts varchar,alb varchar,phos varchar,calc varchar,bun varchar,creat varchar)";
        db.execSQL(sql1);




        spinner1=(Spinner)findViewById(R.id.spinner1);
        adapter1=ArrayAdapter.createFromResource(this,R.array.integer_values,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text1 = spinner1.getSelectedItem().toString();
               // Toast.makeText(getBaseContext(), text1 + " is selected", Toast.LENGTH_SHORT).show();
                // Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        spinner2=(Spinner)findViewById(R.id.spinner2);
        adapter2=ArrayAdapter.createFromResource(this,R.array.integer_values,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text2 = spinner2.getSelectedItem().toString();
                //Toast.makeText(getBaseContext(), text2 + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner3=(Spinner)findViewById(R.id.spinner3);
        adapter3=ArrayAdapter.createFromResource(this,R.array.integer_values,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text3 = spinner3.getSelectedItem().toString();
               // Toast.makeText(getBaseContext(), text3 + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner4=(Spinner)findViewById(R.id.spinner4);
        adapter4=ArrayAdapter.createFromResource(this,R.array.integer_values,android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text4 = spinner4.getSelectedItem().toString();
               // Toast.makeText(getBaseContext(), text4 + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner5=(Spinner)findViewById(R.id.spinner5);
        adapter5=ArrayAdapter.createFromResource(this,R.array.integer_values,android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter3);

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text5 = spinner5.getSelectedItem().toString();
               // Toast.makeText(getBaseContext(), text5 + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner6=(Spinner)findViewById(R.id.spinner6);
        adapter6=ArrayAdapter.createFromResource(this,R.array.integer_values,android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter3);

        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text6 = spinner6.getSelectedItem().toString();
               // Toast.makeText(getBaseContext(), text6 + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner7=(Spinner)findViewById(R.id.spinner7);
        adapter7=ArrayAdapter.createFromResource(this,R.array.integer_values,android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter7);

        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text7 = spinner7.getSelectedItem().toString();
              //  Toast.makeText(getBaseContext(), text7 + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner8=(Spinner)findViewById(R.id.spinner8);
        adapter8=ArrayAdapter.createFromResource(this,R.array.integer_values,android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(adapter8);

        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text8 = spinner8.getSelectedItem().toString();
                //Toast.makeText(getBaseContext(), text8 + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st = e1.getText().toString();
                if(st.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter the date", Toast.LENGTH_LONG).show();
                    return;
                }


                String[] parts = st.split("/");
                String foo1 = parts[0];
                String foo2 = parts[1];
                String foo3 = parts[2];
               // int day = Integer.parseInt(foo1);
               // int month = Integer.parseInt(foo2);

               // int year = Integer.parseInt(foo3);
                DateFormat formatter =new SimpleDateFormat("dd/MM/yyyy");
                formatter.setLenient(false);
                try {
                    Date date=formatter.parse(st);
                } catch (ParseException e) {
                    //If input date is in different format or invalid.
                    Toast.makeText(getApplicationContext(), "wrong format", Toast.LENGTH_LONG).show();
                    return;
                }

                String ppid=Integer.toString(pid);




                Cursor c=db.rawQuery("SELECT * FROM Patient2 WHERE pid = ? AND day= ? AND month=? AND year=?", new String[]{ppid, foo1, foo2, foo3});

               c.moveToFirst();
               count=0;
               while(c.moveToNext()){
                   count++;
                }

                if(count==0) {
                   // Toast.makeText(getApplicationContext(), "new guy only", Toast.LENGTH_LONG).show();
                    String s2="insert into Patient2 values('"+ppid+"','"+foo1+"','"+foo2+"','"+foo3+"','"+text1+"','"+text2+"','"+text3+"','"+text4+"','"+text5+"','"+text6+"','"+text7+"','"+text8+"')";

                    db.execSQL(s2);

                }

                else
                {
                    Toast.makeText(getApplicationContext(), "A Record on this date alreay exists", Toast.LENGTH_LONG).show();
                    return;


                }

int monitor =0;
                String number1 = "9894959779";
                String number2="9597212785";
                String sms ;

                String s1="Patient "+Integer.toString(pid)+" has critical ";
                //String s2="hai";

               int[] values = new int[9];
                //values[1]=Integer.parseInt(text1);
               // s1=s1+"hhhhhhhh:"+text1;
                 values[0]=0;
                 values[1]=Integer.parseInt(text1);
                values[2]=Integer.parseInt(text2);

                values[3]=Integer.parseInt(text3);

                values[4]=Integer.parseInt(text4);

                values[5]=Integer.parseInt(text5);

                values[6]=Integer.parseInt(text6);

                values[7]=Integer.parseInt(text7);

                values[8]=Integer.parseInt(text8);


                if(values[1]<30 || values[1]>36)
                {
                    s1=s1+" Hematocrit:"+text1;
                    monitor=1;



                }
                if(values[2]<10 || values[2]>12)
                {
                    s1=s1+" ,Haemoglobin:"+text2;
                    monitor=1;



                }
                if(values[3]<20 || values[3]>50)
                {
                    s1=s1+" ,Tranferrin Saturation:"+text3;
                    monitor=1;




                }
                if(values[4]<4)
                {
                    s1=s1+" ,Albumin:"+text4;
                    monitor=1;




                }
                if(values[5]<3.5 || values[5]>5.5)
                {

                    s1=s1+" ,Phosphorus:"+text5;
                    monitor=1;



                }
                if(values[6]<8.6 || values[6]>10)
                {
                    s1=s1+" ,Calcium:"+text6;
                    monitor=1;



                }
                if(values[7]<10 || values[7]>20)
                {
                    s1=s1+" ,Blood Urea Nitrogen:"+text7;
                    monitor=1;



                }
                if(values[8]<1 || values[8]>2)
                {
                    s1=s1+" ,Creatine:"+text4;
                    monitor=1;



                }


                s1 = s1.concat(" Values.");



if(monitor==1) {

    try {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number1, null, s1, null, null);
        smsManager.sendTextMessage(number2, null, s1, null, null);

        Toast.makeText(getApplicationContext(), "SMS Sent!",
                Toast.LENGTH_LONG).show();
    } catch (Exception e) {
        Toast.makeText(getApplicationContext(),
                "SMS faild, please try again later!",
                Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }

}





            }
        });



    }


}
