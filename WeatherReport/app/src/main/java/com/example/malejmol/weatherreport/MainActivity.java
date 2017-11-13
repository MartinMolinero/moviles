package com.example.malejmol.weatherreport;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public final static String queryURL = "http://api.openweathermap.org/data/2.5/weather?mode=xml&APPID=3f7ab04d104f83aea0c5ba208af5e41d&" ;


    private class CallAPI extends AsyncTask<String, Void, String>{
        @Override

        protected String doInBackground(String...params) {
            String fullQuery = params[0];
            String apiResponse = "";

            InputStream inputs = null;
            String result = null;

            try {
                URL thisUrl = new URL(fullQuery);
                HttpURLConnection urlConnection = (HttpURLConnection) thisUrl.openConnection();
                inputs = new BufferedInputStream(urlConnection.getInputStream());

            } catch (Exception e ) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }

            XmlPullParserFactory xmlpp;

            try {
                xmlpp = XmlPullParserFactory.newInstance();
                XmlPullParser parser = xmlpp.newPullParser();
                parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                parser.setInput(inputs, null);
                result = parseXML(parser, fullQuery);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (result != null ) {

                apiResponse = result + "\n";
            }
            else {
                apiResponse = "Exception Occured";
            }

            return apiResponse;

        }

        private String parseXML(XmlPullParser parser, String queryString ) throws IOException, XmlPullParserException{
            int evenType = parser.getEventType();
            String result = new String();
            String tag = new String();
            String tagname = new String();


            //result += queryString;

            while(evenType != XmlPullParser.END_DOCUMENT){
                if(evenType == XmlPullParser.START_DOCUMENT){

                }else if(evenType == XmlPullParser.START_TAG){
                    tagname = parser.getName();

                    if(tagname.equalsIgnoreCase("city")) {
                        result += parser.getAttributeValue(null, "name") + ",";
                    }

                    if(tagname.equalsIgnoreCase("temperature")){
                        result+=  parser.getAttributeValue(null, "value") + ",";
                    }

                    if(tagname.equalsIgnoreCase("weather")){
                        result+=  parser.getAttributeValue(null, "value") + ",";
                        result+= parser.getAttributeValue(null, "icon");
                    }

                }
                evenType = parser.next();
            }
            return result;
        }

        protected void onPostExecute(String result){
            String[] arr = result.split(",");
            String city = arr[0];
            Float temperature = Float.parseFloat(arr[1].toString());
            temperature = temperature - 273;
            String climate = arr[2];
            String icon = arr[3];
            Intent firstIntent = new Intent(getApplicationContext(), secondActivity.class);
            firstIntent.putExtra("city", city);
            firstIntent.putExtra("temperature", temperature);
            firstIntent.putExtra("clima", climate);
            firstIntent.putExtra("icon", icon);
            startActivity(firstIntent);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputText =  (EditText) findViewById(R.id.placeText);
        Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String city =  String.valueOf(inputText.getText());

                if(city != null && !city.isEmpty()){

                    String addToUrl = queryURL + "q=" + city;
                    new CallAPI().execute(addToUrl);
                }

            }
        });
    }



}
