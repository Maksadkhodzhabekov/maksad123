package com.example.wskpoliceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowDepartamentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_departament);

        TextView departname = findViewById(R.id.departamentName);
        TextView address = findViewById(R.id.addressName);
        TextView boss = findViewById(R.id.bossName);
        TextView phone = findViewById(R.id.phoneName);
        TextView email = findViewById(R.id.emailName);
        TextView description = findViewById(R.id.descriptionName);

        try{
            departname.setText(Global.selecteddepartament.name);
            address.setText(Global.selecteddepartament.address);
            boss.setText(Global.selecteddepartament.boss);
            phone.setText(Global.selecteddepartament.phone);
            email.setText(Global.selecteddepartament.email);
            description.setText(Global.selecteddepartament.description);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
