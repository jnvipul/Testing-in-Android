package com.example.vj.samplemvpandroid.base;

/**
 * Created by vJ on 2/2/17.
 */

public interface IMvpPresenter<T extends IMvpView> {

    public void attachView(T view);

    public void detachView();

    public boolean isViewAttached();

    public T getView();

}
