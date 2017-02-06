package com.example.vj.samplemvpandroid.utility;

import com.example.vj.samplemvpandroid.retrofit_services.GithubService;

import retrofit2.Retrofit;

/**
 * Created by vJ on 2/6/17.
 */

public class ServiceGenerator {

    public static GithubService getGithubService(Retrofit retrofit){
        return retrofit.create(GithubService.class);
    }
}
