package com.example.vj.samplemvpandroid.list;

import com.example.vj.samplemvpandroid.ApplicationState;
import com.example.vj.samplemvpandroid.model.Repository;
import com.example.vj.samplemvpandroid.retrofit_services.GithubService;

import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by vJ on 1/19/17.
 */

public class ListPresenter implements IRepositoryLoadFinishListener {
    IListActivityView view;
    ListModel model;

    public ListPresenter(IListActivityView view, GithubService githubService) {
        this.view = view;
        this.model = new ListModel(this, githubService);
    }

    public void loadRepositories() {
        model.getRepositories("mevipul");
    }

    @Override
    public void onNetworkSuccess(List<Repository> list) {
        view.onRepositoryLoadSuccess(list);
    }

    @Override
    public void onNetworkFailure(Throwable error) {
        view.onRepositoryLoadFailure(error);
    }
}
