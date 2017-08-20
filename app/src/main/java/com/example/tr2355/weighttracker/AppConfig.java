package com.example.tr2355.weighttracker;

import android.app.Application;
import android.content.res.Configuration;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

/**
 * Created by tr2355 on 8/20/2017.
 */


public class AppConfig extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());

        // create table if not exists
        SchemaGenerator schemaGenerator = new SchemaGenerator(this);
        schemaGenerator.createDatabase(new SugarDb(this).getDB());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }
}
