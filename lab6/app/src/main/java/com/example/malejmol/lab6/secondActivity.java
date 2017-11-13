package com.example.malejmol.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent second = getIntent();
        String responseCon = second.getStringExtra("country");
        String responseStat = second.getStringExtra("state");
        TextView response = (TextView) findViewById(R.id.responsecountry);
        response.setText( "Country selected was " + responseCon);

        TextView state = (TextView) findViewById(R.id.responseState);
        state.setText("State of button is " +  responseStat);

    }

}
