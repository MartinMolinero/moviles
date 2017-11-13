package com.example.malejmol.repaso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    int eleccion = 0;
    int compelec = 0;
    int record;

    public int eligeArt(){
        int res = 0;
        String choice;

        Random randel = new Random();

        res = (int) (randel.nextInt(3) +1);


        switch (res){
            case 1:
                choice = "scissors";
                break;
            case 2:
                choice = "paper";
                break;
            case 3:
                choice = "rock";
                break;
            default:
                choice = "error";
                break;
        }

        Toast.makeText(getApplicationContext(),"Computer has chose " + choice, Toast.LENGTH_LONG).show();

        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1
       final Button scissors = (Button) findViewById(R.id.tijbut);
        //2
        final Button paper = (Button) findViewById(R.id.papbut);
        //3
        final Button rock = (Button) findViewById(R.id.rockbut);

       final Button reset = (Button) findViewById(R.id.resbut);

       final TextView counterView = (TextView) findViewById(R.id.counter);

        scissors.setOnClickListener(new View.OnClickListener(){
            TextView result = (TextView) findViewById(R.id.result);
            @Override
            public void onClick(View v) {
                eleccion = 1;
                compelec = eligeArt();
                if(eleccion == compelec) {
                    result.setText("Tie");
                }else if(compelec == 2){
                    result.setText("You won");
                    record += 1;
                }else if(compelec == 3){
                    result.setText("You lost");
                }else{
                    result.setText("Error");
                }
                counterView.setText(String.valueOf(record));
            }
        });

        paper.setOnClickListener(new View.OnClickListener(){
            TextView result = (TextView) findViewById(R.id.result);
            @Override
            public void onClick(View v) {
                eleccion = 2;
                compelec = eligeArt();
                if(eleccion == compelec) {
                    result.setText("Tie");
                }else if(compelec == 1){
                    result.setText("You lost");

                }else if(compelec == 3){
                    result.setText("You won");
                    record += 1;
                }else{
                    result.setText("Error");
                }
                counterView.setText(String.valueOf(record));
            }
        });

        rock.setOnClickListener(new View.OnClickListener(){
            TextView result = (TextView) findViewById(R.id.result);

            @Override
            public void onClick(View v) {
                eleccion = 3;
                compelec = eligeArt();
                if(eleccion == compelec) {
                    result.setText("Tie");
                }else if(compelec == 1){
                    result.setText("You won");
                    record += 1;

                }else if(compelec == 2){
                    result.setText("You lost");

                }else{
                    result.setText("Error");
                }

                counterView.setText(String.valueOf(record));
            }

        });

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                record = 0;
                counterView.setText(String.valueOf(record));
            }
        });


    }
}
