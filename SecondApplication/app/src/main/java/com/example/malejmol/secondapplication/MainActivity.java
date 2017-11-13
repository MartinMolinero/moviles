package com.example.malejmol.secondapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText myText;
    private EditText myAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (EditText)findViewById(R.id.editText3);
        myAge = (EditText)findViewById(R.id.editText4);


        final Button submitButton;
        submitButton = (Button) findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int age;
                if(myAge.getText().toString().equals(""))
                    age = 0;
                else {
                    age = Integer.valueOf(myAge.getText().toString());
                }
                String name = myText.getText().toString();

                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("name" , name);
                intent.putExtra("age", age);
                startActivity(intent);
            }



        });



    }


}
