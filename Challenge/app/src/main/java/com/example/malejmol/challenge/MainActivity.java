package com.example.malejmol.challenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int scorehuman = 0;
    int scorecp = 0;
    int humanchoice = 0;
    int cpchoice = 0;

    public int escogecompu(){
        int res = 0;
        Random cho = new Random();
        res = (int) (cho.nextInt(3) + 1);

        String message = "";
        switch (res){
            case 1:
                message = "paper";
                break;
            case 2:
                message = "rock";
                break;
            case 3:
                message = "scissors";
                break;
            default:
                message = "error on app";
                break;
        }

        Toast.makeText(getApplicationContext(), "The computer chooses " + message, Toast.LENGTH_LONG).show();
        return res;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button scissors = (Button)findViewById(R.id.tijbut);
        final Button paper = (Button)findViewById(R.id.papbut);
        final Button rock = (Button)findViewById(R.id.piebut);
        final Button reset = (Button)findViewById(R.id.resbut);
        final TextView scoreView = (TextView)findViewById(R.id.counter);
        final TextView winnerView = (TextView)findViewById(R.id.winner);


        paper.setOnClickListener(new View.OnClickListener(){

            String game = "";
            @Override
            public void onClick(View v) {
                humanchoice = 1;
                cpchoice = escogecompu();

                if(humanchoice == cpchoice){
                    game = "Tie!";
                }else if(cpchoice == 2){
                    game = "Player 1 won!";
                    scorehuman += 1;
                }else if(cpchoice == 3){
                    game = "Player 2 won!";
                    scorecp +=1;
                }

                scoreView.setText(String.valueOf(scorehuman) + " - "+ String.valueOf(scorecp));
                winnerView.setText(game);
            }
        });

        rock.setOnClickListener(new View.OnClickListener(){
            String game = "";
            @Override
            public void onClick(View v) {
                humanchoice = 2;
                cpchoice = escogecompu();

                if(humanchoice == cpchoice){
                    game = "Tie!";
                }else if(cpchoice == 3){
                    game = "Player 1 won!";
                    scorehuman += 1;
                }else if(cpchoice == 1){
                    game = "Player 2 won!";
                    scorecp +=1;
                }

                scoreView.setText(String.valueOf(scorehuman) + " - "+ String.valueOf(scorecp));
                winnerView.setText(game);
            }
        });


        scissors.setOnClickListener(new View.OnClickListener(){
            String game = "";
            @Override
            public void onClick(View v) {
                humanchoice = 3;
                cpchoice = escogecompu();

                if(humanchoice == cpchoice){
                    game = "Tie!";
                }else if(cpchoice == 1){
                    game = "Player 1 won!";
                    scorehuman += 1;
                }else if(cpchoice == 2){
                    game = "Player 2 won!";
                    scorecp +=1;
                }

                scoreView.setText(String.valueOf(scorehuman) + " - "+ String.valueOf(scorecp));
                winnerView.setText(game);
            }
        });

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String game = "new Game";
                Toast.makeText(getApplicationContext(), "Player reset the game", Toast.LENGTH_LONG).show();
                scorehuman = 0;
                scorecp= 0;
                scoreView.setText(String.valueOf(scorehuman) + " - "+ String.valueOf(scorecp));
                winnerView.setText(game);
            }
        });

    }
}
