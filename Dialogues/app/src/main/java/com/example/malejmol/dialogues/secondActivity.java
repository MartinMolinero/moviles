package com.example.malejmol.dialogues;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Context context = getApplicationContext();
        Toast firstToast = new Toast(context);
        firstToast.makeText(context, "Hello from this Toast", Toast.LENGTH_LONG).show();
    }
}
