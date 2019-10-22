package com.example.wskpoliceapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CriminalCasesActivity extends AppCompatActivity {
    ExpandableListAdapter expandableListAdapter;
    HashMap<String, List<String>> expListDetail;
    List<String>expListTitle;
    ExpandableListView category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminal_cases);

        category = (ExpandableListView) findViewById(R.id.category_crime);

        try{
            GetCriminalCasesHttp getCriminalCasesHttp = new GetCriminalCasesHttp();
            getCriminalCasesHttp.execute("http://mad2019.hakta.pro/api/criminal_case/");

            String result ="";
            result = getCriminalCasesHttp.get();
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            final List<Criminal> criminals = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i ++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Criminal criminal = new Criminal();
                criminal.id = jsonObject1.getString("id");
                criminal.category = jsonObject1.getString("category");
                criminal.client = jsonObject1.getString("client");
                criminal.create_date = jsonObject1.getString("create_date");
                criminal.number = jsonObject1.getString("number");
                criminal.description = jsonObject1.getString("description");
                criminal.detective = jsonObject1.getString("detective");
                criminals.add(criminal);
            }
            final ArrayList<String> crimDetectives = new ArrayList<>();
            crimDetectives.add("Result (" + criminals.size() + "):");
            for (int i = 0; i < criminals.size(); i++){
                crimDetectives.add(criminals.get(i).toString());
            }
            expListDetail = CriminalData.LoadData(crimDetectives);

            expListTitle = new ArrayList<>(expListDetail.keySet());
            ExpandCaseAdapter expandCaseAdapter = new ExpandCaseAdapter(this, expListTitle, expListDetail);
            category.setAdapter(expandCaseAdapter);

            category.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View view, int i, int i1, long l) {
                    if (i == 0){
                        if(i1 != 0){
                            Criminal selectedCriminal = criminals.get((int) l - 1);
                            Global.selectedCriminal = selectedCriminal;
                            Intent intent = new Intent(CriminalCasesActivity.this, ShowCriminalCasesActivity.class);
                            startActivity(intent);
                        }
                    }
                    return false;
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_criminal_cases, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addCriminal:
                Intent intent = new Intent(CriminalCasesActivity.this, NewCriminalCasesActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
