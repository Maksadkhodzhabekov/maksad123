package com.example.wskpoliceapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DepartamentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departaments);
        try {
            HttpGetRequest getdepartaments = new HttpGetRequest();
            getdepartaments.execute("http://mad2019.hakta.pro/api/department/");
            String result = getdepartaments.get();
            JSONObject object = new JSONObject(result);
            JSONArray array = object.getJSONArray("data");
            final ArrayList<Departament> departaments = new ArrayList<>();
            for (int i = 0; i < array.length(); i ++){
                JSONObject departament = array.getJSONObject(i);
                Departament object1 = new Departament();
                object1.id = departament.getString("id");
                object1.address = departament.getString("address");
                object1.name = departament.getString("name");
                object1.boss = departament.getString("boss");
                object1.phone = departament.getString("phone");
                object1.email = departament.getString("email");
                object1.description = departament.getString("description");
                departaments.add(object1);
            }
            ListView listView = findViewById(R.id.depart_list);
            DepartamentAdapter departamentAdapter = new DepartamentAdapter(this, R.layout.departament_layout, departaments);
            /*ArrayAdapter<Departament> departamentAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, departaments){
                @Override
                public View getView(int position,  View convertView,  ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    return view;
                }
            };*/
            listView.setAdapter(departamentAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Departament departament = departaments.get(position);
                    Global.selecteddepartament = departament;
                    Intent intent = new Intent(DepartamentsActivity.this, ShowDepartamentActivity.class);
                    startActivity(intent);
                }
            });


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
