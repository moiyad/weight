package com.example.tr2355.weighttracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tr2355.weighttracker.data.Plan;
import com.example.tr2355.weighttracker.data.Record;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage,currentW,goalW,numberW,remainW;
    private EditText newWeight;
    private Button newWeightButton;
    ListView listView;
    List<Record> records;
    List<Plan> plans;
    LinearLayout layoutInfo,layoutRecord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newWeight =(EditText)findViewById(R.id.new_weight);
        currentW =(TextView)findViewById(R.id.current_weightView);
        goalW =(TextView)findViewById(R.id.goal_weightView);
        numberW =(TextView)findViewById(R.id.numberWeekView);
        remainW =(TextView)findViewById(R.id.week_remainView);
        newWeightButton =(Button)findViewById(R.id.new_weightB);
        layoutInfo =(LinearLayout)findViewById(R.id.layout_info);
        layoutRecord =(LinearLayout)findViewById(R.id.layout_record_s);
        listView =(ListView)findViewById(R.id.listRecord);
        mTextMessage = (TextView) findViewById(R.id.message);

        layoutRecord.setVisibility(View.INVISIBLE);
        plans = Plan.listAll(Plan.class);
        records =Record.listAll(Record.class);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            switch (item.getItemId()) {

                case R.id.navigation_home:


                    mTextMessage.setText(R.string.title_home);
                    listView.setVisibility(View.VISIBLE);
                    layoutInfo.setVisibility(View.VISIBLE);
                    layoutRecord.setVisibility(View.INVISIBLE);

                    LayoutInformation();

                    return true;

                case R.id.navigation_record:


                    mTextMessage.setText("Record");
                    layoutRecord.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.INVISIBLE);
                    layoutInfo.setVisibility(View.INVISIBLE);

                    newWeightButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Record record =new Record(Double.parseDouble(String.valueOf(newWeight.getText())));
                            record.save();
                            Toast.makeText(MainActivity.this, "size : "+ LastIndexRecord(), Toast.LENGTH_SHORT).show();

                        }
                    });
                    return true;

                case R.id.navigation_newPlan:

                    Intent intent = new Intent(MainActivity.this,NewPlan.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }

    };


public double LastIndexRecord(){
    records =Record.listAll(Record.class);
    if (!records.isEmpty()){
        return records.get(records.size()-1).getRecord();
    }
    return 0;
    }
    public void LayoutInformation(){

        if(plans.size()==0){
            Toast.makeText(this, "There no plan yet", Toast.LENGTH_SHORT).show();
        }
        else {
            if (records.size() == 0) {
                currentW.setText("Current Weight : " + "Empty plan");
                remainW.setText("Weeks Remain : " + String.valueOf(plans.get(0).getWeek()));
                goalW.setText("Goal Weight : " + String.valueOf(plans.get(0).getGoalWeight()));
                numberW.setText("Weeks : " + String.valueOf(plans.get(0).getWeek()));
            } else {
                currentW.setText("Current Weight : " + records.get(records.size() - 1).getRecord());
                goalW.setText("Goal Weight : " + String.valueOf(plans.get(0).getGoalWeight()));
                numberW.setText("Weeks : " + String.valueOf(plans.get(0).getWeek()));
                remainW.setText("Weeks Remain : " + String.valueOf(plans.get(0).getWeek() - records.size()));
            }
        }
    }
}
