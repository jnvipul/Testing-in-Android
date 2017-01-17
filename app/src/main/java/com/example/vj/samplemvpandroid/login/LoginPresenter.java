package com.example.vj.samplemvpandroid.login;

/**
 * Created by vJ on 1/18/17.
 */

public class LoginPresenter {

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
