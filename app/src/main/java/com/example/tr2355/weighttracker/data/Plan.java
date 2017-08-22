package com.example.tr2355.weighttracker.data;

import com.orm.SugarRecord;

/**
 * Created by tr2355 on 8/20/2017.
 */

public class Plan extends SugarRecord {
    double currentWeight;
    double goalWeight;
    int week;


    public Plan() {
    }

    public Plan(double currentWeight, double goalWeight, int week) {

        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.week = week;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
