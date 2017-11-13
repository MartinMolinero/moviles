package com.example.malejmol.weatherreport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class secondActivity extends AppCompatActivity {



    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String ciudad = intent.getStringExtra("city");
        Float temp = intent.getFloatExtra("temperature", (float) 0.0);
        String apariencia = intent.getStringExtra("clima");
        String icon = intent.getStringExtra("icon");

        TextView cityText = (TextView) findViewById(R.id.citycont);
        TextView temperatura = (TextView) findViewById(R.id.degreescont);
        TextView clima = (TextView) findViewById(R.id.climcont);
        ImageView iconoView = (ImageView) findViewById(R.id.iconcont);

        cityText.setTextSize(30);
        cityText.setText(ciudad);

        temperatura.setTextSize(26);
        temperatura.setText(String.format("%.02f", temp) + " °C");
        clima.setTextSize(20);
        clima.setText(apariencia);

        String urlIcon = "http://openweathermap.org/img/w/"+icon+".png";
        new DownloadImageTask( (ImageView)findViewById(R.id.iconcont)).execute(urlIcon);
    }







    }
