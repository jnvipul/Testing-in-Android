package com.example.vj.samplemvpandroid.login;

import com.example.vj.samplemvpandroid.list.IListPresenter;
import com.example.vj.samplemvpandroid.list.IRepositoryLoadFinishListener;
import com.example.vj.samplemvpandroid.model.Repository;

import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by vJ on 1/18/17.
 */

public class LoginPresenter{

    private ILoginView view;
    private SyncronusLoginModel model;

    public LoginPresenter(ILoginView view) {
        this.view = view;
        this.model = new SyncronusLoginModel();
    }

    public void attemptLogin(String username, String password) {
        if (model.validateCredentials(username, password)) {
            view.loginSuccessful();
        } else {
            view.loginFailed();
        }
    }
}
