package com.example.android.myhealth;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 4/12/2016.
 */
public class new_user extends FragmentActivity {

    Spinner spinner1;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    ArrayAdapter<CharSequence> adapter1;
    EditText e1,e2,e3,e4,e5,e6;
    Button b1;
    String text1;
    String sql1;
    TextView tc;
    //String name;
    String db_name="jeff";
    SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);

        Intent i=getIntent();
        final int pid=i.getIntExtra("text",0);
         //Toast.makeText(getApplicationContext(),Integer.toString(pid),Toast.LENGTH_LONG).show();


        b1=(Button)findViewById(R.id.btnButton3);

        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup);

        e1=(EditText)findViewById(R.id.name);//name
        e2=(EditText)findViewById(R.id.LinearLayout1);//birth date
        e3=(EditText)findViewById(R.id.age);//age
        e4=(EditText)findViewById(R.id.addr);//address
        e5=(EditText)findViewById(R.id.mail_text_box);//email id

        e6=(EditText)findViewById(R.id.etnumber);//contact number





        db=openOrCreateDatabase(db_name,MODE_PRIVATE,null);
        sql1="create table if not exists Patient1(pid int PRIMARY KEY NOT NULL,name varchar,age int,day int,month int,year int,bld_grp varchar,gender varchar,address varchar,email varchar,ph_no varchar)";
       db.execSQL(sql1); //db.rawQuery();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //name variable
                String name=e1.getText().toString();

                if(name.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_LONG).show();
                    return;
                }
                //age
                String age=e3.getText().toString();
                if(age.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter an age", Toast.LENGTH_LONG).show();
                    return;
                }

                //birth date
                String st=e2.getText().toString();
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
                int day = Integer.parseInt(foo1);
                int month = Integer.parseInt(foo2);
                int year = Integer.parseInt(foo3);


                //text1 spinner is already there

                //radio button
                int selectedId = radioSexGroup.getCheckedRadioButtonId();
                radioSexButton = (RadioButton) findViewById(selectedId);
                if(!radioSexButton.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "Please select your gender", Toast.LENGTH_LONG).show();
                    return;
                }

                String radio=radioSexButton.getText().toString();

               //address

                String address=e4.getText().toString();
                if(address.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "Enter an address", Toast.LENGTH_LONG).show();
                    return;
                }

                //email id
                String email_id=e5.getText().toString();

                String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
                java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
                java.util.regex.Matcher m = p.matcher(email_id);
                if(!m.matches())
                {
                    Toast.makeText(getApplicationContext(), "Enter email id in correct format", Toast.LENGTH_LONG).show();
                    return;
                }

                //contact number
                String c_num=e6.getText().toString();





                // Toast.makeText(getApplicationContext(), name + "," + age + "," + day + "," + month + "," + year + "," + text1 + "," + radio + "," + address + "," + email_id + "," + c_num, Toast.LENGTH_LONG).show();


                String s2="insert into Patient1 values('"+pid+"','"+name+"','"+age+"','"+day+"','"+month+"','"+year+"','"+text1+"','"+radio+"','"+address+"','"+email_id+"','"+c_num+"')";

                db.execSQL(s2);
//
//                Cursor c=db.rawQuery("select * from Patient1 where pid=123",null);
//                c.moveToFirst();
//               do {
//                   String s4 = c.getString(1);
//                   Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_LONG).show();
//                }while(c.moveToNext());

            }
        });
// Spinner element
        spinner1=(Spinner)findViewById(R.id.spinner2);
        adapter1=ArrayAdapter.createFromResource(this, R.array.blood_group, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text1 = spinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

}
