package com.example.malejmol.dialogues;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        final Context context = getApplicationContext();
        AlertDialog.Builder simpleDialog = new AlertDialog.Builder(this);
        simpleDialog.setTitle("Yes/no/cancel dialog");
        simpleDialog.setMessage("Make your choice");
        simpleDialog.setIcon(R.mipmap.ic_launcher);

        simpleDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){
                Toast.makeText(context, "You chose yes", Toast.LENGTH_LONG).show();
            }
        });

        simpleDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){
                Toast.makeText(context, "You chose no", Toast.LENGTH_LONG).show();
            }
        });

        simpleDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id){
                Toast.makeText(context, "Transaction canceled", Toast.LENGTH_LONG).show();
                Intent dismissIntent = new Intent(context, MainActivity.class);
                startActivity(dismissIntent);
            }
        });

        AlertDialog whateverDialog = simpleDialog.create();
        whateverDialog.show();
    }
}
