package com.example.android.myhealth;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    EditText e1;
    String s1;
    int count;
    String db_name="jeff";
    SQLiteDatabase db;
    int pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db=openOrCreateDatabase(db_name,MODE_PRIVATE,null);


        Button button1 = (Button) findViewById(R.id.login_button);
        Button button2=(Button) findViewById(R.id.sign_up_button);
        Button button3=(Button) findViewById(R.id.retrieve_button);
        e1=(EditText)findViewById(R.id.patient_id);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                if (s1.matches("") || !(s1.matches("[0-9]+")) ) {
                    Toast.makeText(getApplicationContext(), "You did not enter a valid  Patient id", Toast.LENGTH_SHORT).show();
                    return;
                }


               pid=Integer.parseInt(s1);


                Cursor c=db.rawQuery("select * from Patient1 where pid='" + pid + "'",null);
                c.moveToFirst();
                count=0;
                while(c.moveToNext()){
                    count++;
                }

                if(count==0)
                   // Toast.makeText(getApplicationContext(), "old guy only", Toast.LENGTH_LONG).show();

                {

                    Toast.makeText(getApplicationContext(), "No patient id found", Toast.LENGTH_LONG).show();
                    return;
                }


                Intent i=new Intent(MainActivity.this,activity_loginned.class);
                i.putExtra("text",pid);
                startActivity(i);
            }
        });








            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String s1 = e1.getText().toString();
                    if (s1.matches("") ) {
                        Toast.makeText(getApplicationContext(), "Enter the Patient id you wish to have", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if( !(s1.matches("[0-9]+")))
                    {
                        Toast.makeText(getApplicationContext(), "Please enter a valid Patient id", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    int pid = Integer.parseInt(s1);

                    Cursor c=db.rawQuery("select * from Patient1 where pid='" + pid + "'",null);
                    c.moveToFirst();
                    count=0;
                    while(c.moveToNext()){
                        count++;
                    }

                    if(count==0) {
                       // Toast.makeText(getApplicationContext(), "new guy only", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Patient id already exists", Toast.LENGTH_LONG).show();
                        return;

                    }




                    Intent i = new Intent(MainActivity.this, new_user.class);
                    i.putExtra("text", pid);
                    startActivity(i);

                }
            });




        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                if (s1.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter Patient id", Toast.LENGTH_SHORT).show();
                    return;
                }
                int pid=Integer.parseInt(s1);

                Intent i=new Intent(MainActivity.this,retrieve_activity.class);
                i.putExtra("text",pid);
                startActivity(i);

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
