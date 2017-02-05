package com.example.vj.samplemvpandroid.list;

import com.example.vj.samplemvpandroid.ApplicationState;
import com.example.vj.samplemvpandroid.model.Repository;
import com.example.vj.samplemvpandroid.retrofit_services.GithubService;
import com.google.common.util.concurrent.AbstractScheduledService;

import java.util.List;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by vJ on 1/19/17.
 */

public class ListPresenter {
    IListActivityView view;
    ListModel model;

    public ListPresenter(IListActivityView view, GithubService githubService) {
        this.view = view;
        this.model = new ListModel(githubService);
    }

    public void loadRepositories() {
        view.showProgressBar();
        model.getRepositories("mevipul")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onLoadSuccess, this::onLoadFailure);
    }

    public void onLoadSuccess(List<Repository> list) {
        view.onRepositoryLoadSuccess(list);
        view.hideProgressBar();
    }

    public void onLoadFailure(Throwable error) {
        view.onRepositoryLoadFailure(error);
        view.hideProgressBar();
    }
}
