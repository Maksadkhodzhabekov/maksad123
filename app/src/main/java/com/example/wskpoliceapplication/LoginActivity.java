package com.example.wskpoliceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button guestButton = findViewById(R.id.guestButton);
        Button signinButton = findViewById(R.id.signinButton);
        Button criminalCases = findViewById(R.id.criminalCases);
        Button detectivesButton = findViewById(R.id.detectivesButton);
        Button logoutButton = findViewById(R.id.logout);
        Button paintButton = findViewById(R.id.paintButton);
        final EditText logintext = findViewById(R.id.loginText);
        final EditText passwordtext = findViewById(R.id.passwordText);


        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!logintext.getText().toString().equals("") && !passwordtext.getText().toString().equals("")){
                    try {
                        HttpGetRequest httpGetRequest = new HttpGetRequest();
                        String data = httpGetRequest.execute("http://mad2019.hakta.pro/api/login/?login="+logintext.getText().toString()+"&password="+passwordtext.getText().toString()).get();

                        JSONObject jsonObject = new JSONObject((data));
                        if (jsonObject.getBoolean("success")){
                            Global.isSignin = true;
                            JSONObject usertoken = jsonObject.getJSONObject("data");
                            Global.userId = usertoken.getString("id");
                            Global.token = usertoken.getString("token");
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Введите логин и пароль", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Введите логин и пароль", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                }else {
                    Toast.makeText(getApplicationContext(),"Введите логин и пароль",Toast.LENGTH_LONG).show();
                }
            }
        });

        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Вы вошли, как гость", Toast.LENGTH_LONG).show();
                Global.isSignin = false;
            }
        });

    }

}
