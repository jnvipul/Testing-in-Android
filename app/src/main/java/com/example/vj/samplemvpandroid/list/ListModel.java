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

/**
 * Created by vJ on 1/19/17.
 */
public class ListModel implements Callback<List<Repository>> {

    GithubService githubService;

    private final IRepositoryLoadFinishListener listener;

    public ListModel(IRepositoryLoadFinishListener listener, GithubService githubService) {
        this.listener = listener;
        this.githubService = githubService;
    }

    public void getRepositories(String username) {
        try {
            githubService.listRepos(username).enqueue(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
        listener.onNetworkSuccess(response.body());
    }

    @Override
    public void onFailure(Call<List<Repository>> call, Throwable t) {
        listener.onNetworkFailure(t);
    }
}
