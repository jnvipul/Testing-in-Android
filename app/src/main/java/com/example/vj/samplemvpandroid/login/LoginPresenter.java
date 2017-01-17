package com.example.vj.samplemvpandroid.login;

/**
 * Created by vJ on 1/18/17.
 */

public class LoginPresenter {

    private ILoginView view;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }

    public void attemptLogin(String username, String password) {

        // TODO Check credentials
        view.loginSuccessful();
    }
}
