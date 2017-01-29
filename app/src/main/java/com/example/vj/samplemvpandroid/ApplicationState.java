package com.example.vj.samplemvpandroid;

import android.app.Application;

import com.example.vj.samplemvpandroid.retrofit_services.GithubService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vJ on 1/29/17.
 */

public class ApplicationState extends Application {

    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        setup();
    }

    private void setup() {

    }

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public GithubService getGithubService() {
        return getRetrofit().create(GithubService.class);
    }
}
