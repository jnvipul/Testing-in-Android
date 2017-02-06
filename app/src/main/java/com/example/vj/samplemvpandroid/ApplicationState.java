package com.example.vj.samplemvpandroid;

import android.app.Application;

import com.example.vj.samplemvpandroid.retrofit_services.GithubService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
