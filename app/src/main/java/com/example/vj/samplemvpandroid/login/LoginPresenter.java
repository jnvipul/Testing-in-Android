package com.example.vj.samplemvpandroid.login;

import com.example.vj.samplemvpandroid.base.BasePresenter;

/**
 * Created by vJ on 1/18/17.
 */

public class LoginPresenter extends BasePresenter<ILoginView>{

    private SyncronusLoginModel model;

    public LoginPresenter(SyncronusLoginModel model) {
        this.model = model;
    }

    public void attemptLogin(String username, String password) {
        getView().showProgressBar();
        if (model.validateCredentials(username, password)) {
            getView().loginSuccessful();
        } else {
            getView().loginFailed();
        }
        getView().hideProgressBar();
    }
}
