package com.example.vj.samplemvpandroid.login;

import com.example.vj.samplemvpandroid.base.IMvpView;

/**
 * Created by vJ on 1/18/17.
 */

public interface ILoginView extends IMvpView {

    void loginFailed();

    void loginSuccessful();

    void showProgressBar();

    void hideProgressBar();
}
