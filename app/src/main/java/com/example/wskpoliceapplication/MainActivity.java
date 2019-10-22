package com.example.wskpoliceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutUs = findViewById(R.id.aboutUs);
        Button paintButton = findViewById(R.id.paintButton);
        Button departButton = findViewById(R.id.departamentButton);
        Button criminalCases = findViewById(R.id.criminalCases);
        Button detectivesButton = findViewById(R.id.detectivesButton);
        Button logoutButton = findViewById(R.id.logout);
        Button wantedButton = findViewById(R.id.wantedButton);

        if (Global.isSignin == true){
            criminalCases.setVisibility(View.VISIBLE);
            detectivesButton.setVisibility(View.VISIBLE);
            logoutButton.setVisibility(View.VISIBLE);
            paintButton.setVisibility(View.GONE);
        }

        wantedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantedActivity.class);
                startActivity(intent);
            }
        });

        departButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DepartamentsActivity.class);
                startActivity(intent);
            }
        });
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });
        paintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PaintActivity.class);
                startActivity(intent);
            }
        });
        criminalCases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CriminalCasesActivity.class);
                startActivity(intent);
            }
        });
    }

}
