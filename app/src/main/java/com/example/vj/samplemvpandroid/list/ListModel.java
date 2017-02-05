package com.example.vj.samplemvpandroid.list;

import android.util.Log;

import com.example.vj.samplemvpandroid.retrofit_services.GithubService;
import com.example.vj.samplemvpandroid.model.Repository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by vJ on 1/19/17.
 */
public class ListModel {

    GithubService githubService;

    public ListModel(GithubService githubService) {
        this.githubService = githubService;
    }

    public Observable<List<Repository>> getRepositories(String username) {
        try {
            return githubService.listRepos(username);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
