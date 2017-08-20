package com.example.tr2355.weighttracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tr2355 on 8/20/2017.
 */

public class RecordAdapter extends ArrayAdapter<Record> {

        Record record;
        List<Plan> planList;
        List<Record> recordList;

        public RecordAdapter(@NonNull Context context, List<Record> records) {
            super(context, 0, records);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            int w =planList.get(0).week -recordList.size();
            double different =record.getRecord() ;

            View view = convertView;
            Record current = getItem(position);
            if (convertView == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            TextView currentList = (TextView) view.findViewById(R.id.CurrentList);
            TextView WeekList = (TextView) view.findViewById(R.id.WeekList);
            TextView LastWeekList = (TextView) view.findViewById(R.id.LastWeekList);


            currentList.setText(String.valueOf(current.getRecord()));
            WeekList.setText(String.valueOf(w));
            LastWeekList.setText(String.valueOf(different));

            return view;
        }


    }

