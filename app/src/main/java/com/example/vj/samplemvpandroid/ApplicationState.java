package com.example.vj.samplemvpandroid;

import android.app.Application;

import retrofit2.Retrofit;

/**
 * Created by vJ on 1/29/17.
 */

public class ApplicationState extends Application {

    private Retrofit retrofit;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setup();
    }

    private void setup() {
        // create ApplicationComponent
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
