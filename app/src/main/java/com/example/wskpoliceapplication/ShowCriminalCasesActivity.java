package com.example.wskpoliceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowCriminalCasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_criminal_cases);


       // svernut = findViewById(R.id.hightButton);
        final ScrollView scrollDescription = findViewById(R.id.scrollDescription);
        TextView number = findViewById(R.id.numberText);
        TextView date = findViewById(R.id.dateText);
        TextView client = findViewById(R.id.clientText);
        TextView category = findViewById(R.id.categoryText);
        TextView detective = findViewById(R.id.detectiveText);
        TextView description = findViewById(R.id.descriptonCase);

        number.setText(Global.selectedCriminal.number);
        date.setText(Global.selectedCriminal.create_date);
        client.setText(Global.selectedCriminal.client);
        category.setText(Global.selectedCriminal.category);
        detective.setText(Global.selectedCriminal.detective);
        description.setText(Global.selectedCriminal.description);

       /* try{
            final boolean[] isButtonHight = {false};
            svernut[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isButtonHight[0] == false){
                        scrollDescription.setVisibility(View.GONE);
                        isButtonHight[0] = true;
                    }else {
                        scrollDescription.setVisibility(View.VISIBLE);
                        isButtonHight[0] = false;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
