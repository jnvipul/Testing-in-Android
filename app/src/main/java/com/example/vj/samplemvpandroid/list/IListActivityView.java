package com.example.vj.samplemvpandroid.list;

import com.example.vj.samplemvpandroid.model.Repository;

import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by vJ on 1/19/17.
 */

public interface IListActivityView {

    void onRepositoryLoadSuccess(List<Repository> list);

    void onRepositoryLoadFailure(Throwable error);
}
