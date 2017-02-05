package com.example.vj.samplemvpandroid.retrofit_services;


import com.example.vj.samplemvpandroid.model.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by vJ on 1/19/17.
 */

public interface GithubService {
    @GET("users/{user}/repos")
    Observable<List<Repository>> listRepos(@Path("user") String user);
}
