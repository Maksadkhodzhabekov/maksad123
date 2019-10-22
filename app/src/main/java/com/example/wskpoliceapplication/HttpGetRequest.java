package com.example.wskpoliceapplication;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetRequest extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        String stringUrl = strings[0];
        String result = "";
        String inputline;
        try{
            URL url = new URL(stringUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            //connection.setConnectTimeout(5000000);
           // connection.setReadTimeout(5000000);
            connection.connect();

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputline = bufferedReader.readLine()) != null){
                    stringBuilder.append(inputline);
            }
            bufferedReader.close();
            reader.close();
            result = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            result = "";
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
