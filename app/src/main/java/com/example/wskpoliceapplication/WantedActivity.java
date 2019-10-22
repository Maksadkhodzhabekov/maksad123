package com.example.wskpoliceapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class WantedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wanted);

        try {
            HttpGetRequest getWanted = new HttpGetRequest();
            getWanted.execute("http://mad2019.hakta.pro/api/wanted/");
            String result = getWanted.get();
            JSONObject object = new JSONObject(result);
            JSONArray array = object.getJSONArray("data");
            final ArrayList<Wanted> wanteds = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                JSONObject wanted = array.getJSONObject(i);
                Wanted object1 = new Wanted();
                object1.id = wanted.getString("id");
                object1.first_name = wanted.getString("first_name");
                object1.last_name = wanted.getString("last_name");
                object1.last_location = wanted.getString("last_location");
                object1.status = wanted.getString("status");
                object1.nicknames = wanted.getString("nicknames");
                object1.description = wanted.getString("description");
                object1.photo = wanted.getString("photo");
                wanteds.add(object1);
            }
            ListView listView = findViewById(R.id.wantedList);
            ArrayAdapter<Wanted> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wanteds);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Wanted wanted = wanteds.get(position);
                    Global.selectedWanted = wanted;
                    Intent intent = new Intent(WantedActivity.this, ShowWantedActivity.class);
                    startActivity(intent);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.wanted_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addItem:
                Intent intent = new Intent(WantedActivity.this, AddNewWantedActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
