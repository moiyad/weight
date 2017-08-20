package com.example.tr2355.weighttracker;

import com.orm.SugarRecord;

/**
 * Created by tr2355 on 8/20/2017.
 */

public class Record extends SugarRecord {

    private double record;

    public Record() {
    }

    public Record(double record) {

        this.record = record;
    }

    public double getRecord() {
        return record;
    }

    public void setRecord(double record) {
        this.record = record;
    }


}
