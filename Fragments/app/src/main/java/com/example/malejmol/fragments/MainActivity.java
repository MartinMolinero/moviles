package com.example.malejmol.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button firstButton = (Button) findViewById(R.id.b1);
        final Button secondButton = (Button) findViewById(R.id.b2);


        firstButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FirstFragment first = new FirstFragment();
                //normally you use ft.add in the first time, but since i want to be alternating between fragments 1 and 2,
                // i used replace for a more generic case
                //fraglay is the id for the linearLayout i used for putting the fragments,
                // as suggested on https://developer.android.com/guide/components/fragments.html?hl=es#Creating
                ft.replace(R.id.fraglay, first);
                //allow user to go back by saving previous state on BackStack
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        secondButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                SecondFragment second = new SecondFragment();
                //Same as above
                ft.replace(R.id.fraglay, second);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }


}
