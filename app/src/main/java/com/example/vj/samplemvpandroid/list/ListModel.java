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

    private final IRepositoryLoadFinishListener listener;

    public ListModel(IRepositoryLoadFinishListener listener) {
     this.listener = listener;
    }

    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public GithubService getGithubService() {
        return getRetrofit().create(GithubService.class);
    }

    public void getRepositories() {
        try {
             getGithubService().listRepos("mevipul").enqueue(this);
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
