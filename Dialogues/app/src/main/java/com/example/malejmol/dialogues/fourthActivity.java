package com.example.malejmol.dialogues;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class fourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = getApplicationContext();
        setContentView(R.layout.activity_fourth);
        AlertDialog.Builder inputdialog = new AlertDialog.Builder(this);
        inputdialog.setTitle("Input Dialog");
        inputdialog.setMessage("Please insert a message");
        inputdialog.setIcon(R.mipmap.ic_launcher);
        final EditText input = new EditText(context);
        input.setTextSize(23);
        input.setTextColor(Color.RED);
        inputdialog.setView(input);
        inputdialog.setNeutralButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String message = input.getEditableText().toString();
                Toast.makeText(context, "Current Message " + message, Toast.LENGTH_LONG).show();
                Intent returnIntent = new Intent(context, MainActivity.class);
                startActivity(returnIntent);
            }
        });
        AlertDialog showDialog = inputdialog.create();
        showDialog.show();
    }
}
