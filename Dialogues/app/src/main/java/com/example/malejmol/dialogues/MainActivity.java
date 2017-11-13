package com.example.malejmol.dialogues;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button firstButton = (Button) findViewById(R.id.fbutton);
        final Button secondButton = (Button) findViewById(R.id.sbutton);
        final Button thirdButton = (Button) findViewById(R.id.tbutton);
        final Button fourthButton = (Button) findViewById(R.id.fobutton);
        final Context context = getApplicationContext();
        firstButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent1 = new Intent(context, secondActivity.class);
                startActivity(intent1);

            }
        });

        secondButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent2 = new Intent(context, thirdActivity.class);
                startActivity(intent2);
            }
        });

        thirdButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent3 = new Intent(context, fourthActivity.class);
                startActivity(intent3);
            }
        });

        fourthButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent4 = new Intent(context, fifthActivity.class);
                startActivity(intent4);
            }
        });
    }
}
