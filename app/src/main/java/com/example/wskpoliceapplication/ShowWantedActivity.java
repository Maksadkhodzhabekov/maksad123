package com.example.wskpoliceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ShowWantedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_wanted);

        TextView statusEdit = findViewById(R.id.statusEdit);
        TextView firstname = findViewById(R.id.first_name);
        TextView lastname = findViewById(R.id.last_name);
        TextView middlename = findViewById(R.id.middlename);
        TextView nicknames = findViewById(R.id.nicknames);
        TextView last_location = findViewById(R.id.last_location);
        TextView description = findViewById(R.id.descriptionWanted);
        ImageView photo = findViewById(R.id.photoWanted);

        statusEdit.setText(Global.selectedWanted.status);
        firstname.setText(Global.selectedWanted.first_name);
        lastname.setText(Global.selectedWanted.last_name);
        middlename.setText(Global.selectedWanted.middlename);
        nicknames.setText(Global.selectedWanted.nicknames);
        last_location.setText(Global.selectedWanted.last_location);
        description.setText(Global.selectedWanted.description);

        final Bitmap bitmap;
        try{
            bitmap = new AsyncTask<String, Void, Bitmap>(){

                @Override
                protected Bitmap doInBackground(String... strings) {
                    Bitmap map = null;
                    try{
                        URL url = new URL(strings[0]);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.connect();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        map = BitmapFactory.decodeStream(inputStream);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return map;
                }
            }.execute(Global.selectedWanted.photo).get();
            photo.setImageBitmap(bitmap);
        }catch (Exception e){

        }
    }
}
