package com.example.administrator.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences share=getSharedPreferences("Highest", MODE_PRIVATE);
        final SharedPreferences.Editor change= share.edit();

        final EditText in=(EditText)findViewById(R.id.number);
        final TextView out=(TextView)findViewById(R.id.highnumber);
        final Button   store=(Button)findViewById(R.id.store);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             SharedPreferences res=getSharedPreferences("Highest",MODE_PRIVATE);
             int ref=res.getInt("highest",0);
                String num=in.getText().toString();
                int newnum=Integer.parseInt(num);

                if(newnum>ref)
                {ref=newnum;
                    change.putInt("highest",newnum);
                    change.commit();

            }

            out.setText(ref+"");
        }});
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
