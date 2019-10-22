package com.example.wskpoliceapplication;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetCriminalCasesHttp extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... strings) {
        String stringurl = strings[0];
        String result = "";
        String inputline;

        try{
            URL url = new URL(stringurl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("user_id", Global.userId);
            connection.setRequestProperty("token", Global.token);
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

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
