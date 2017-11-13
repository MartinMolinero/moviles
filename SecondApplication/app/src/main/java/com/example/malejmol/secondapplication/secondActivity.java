package com.example.malejmol.secondapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0 );


        TextView nameTextView = (TextView) findViewById(R.id.targetText);
        nameTextView.setText("Your name is " + name.toString() + "\nYou are " + age + " years old");


    }
}
