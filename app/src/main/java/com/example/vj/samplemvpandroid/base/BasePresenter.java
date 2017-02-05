package com.example.vj.samplemvpandroid.base;

/**
 * Created by vJ on 2/2/17.
 */

public class BasePresenter<T extends IMvpView> implements IMvpPresenter<T> {

    private T view;

    @Override
    public void attachView(T view){
        this.view = view;
    }

    @Override
    public void detachView(){
        this.view = null;
    }

    @Override
    public boolean isViewAttached(){
        return view != null;
    }

    @Override
    public T getView(){
        return view;
    }

    public ViewNotAttachedException checkViewAttached(){
        return new ViewNotAttachedException();
    }

    private static class ViewNotAttachedException extends RuntimeException{
        public ViewNotAttachedException() {
            super("Please call Presenter.attachView(mvpView) before using Presenter");
        }
    }
}