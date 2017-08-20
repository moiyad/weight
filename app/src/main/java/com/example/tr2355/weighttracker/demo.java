package com.example.tr2355.weighttracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * Created by tr2355 on 8/20/2017.
 */

public class demo extends AppCompatActivity {

    EditText currentW,goalW,weeks;
    Button done;
    List<Plan> list ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);

        list =Plan.listAll(Plan.class);

        currentW =(EditText)findViewById(R.id.CurrentPlan);
        goalW =(EditText)findViewById(R.id.goalWeightPlan);
        weeks =(EditText)findViewById(R.id.WeekPlan);
        done =(Button)findViewById(R.id.submitPlan);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Plan.deleteAll(Plan.class);
                Plan plan = new Plan(Double.parseDouble(String.valueOf(currentW.getText())),Double.parseDouble(String.valueOf(goalW.getText())),Integer.parseInt(String.valueOf(weeks.getText())));
                plan.save();
                Toast.makeText(demo.this, "size : "+list.size(), Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(demo.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
