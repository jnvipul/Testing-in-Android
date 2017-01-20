package com.example.vj.samplemvpandroid.list;

import com.example.vj.samplemvpandroid.model.Repository;

import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by vJ on 1/20/17.
 */

public interface IRepositoryLoadFinishListener {

    void onNetworkSuccess(List<Repository> list);

    void onNetworkFailure(Throwable error);

}
