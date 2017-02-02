package com.example.vj.samplemvpandroid.login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vJ on 2/2/17.
 */
public class LoginPresenterTest {

    @Mock
    SyncronusLoginModel model;

    @Mock
    ILoginView view;

    LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(model);
        presenter.attachView(view);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void attemptLogin_when_successful() throws Exception {
        when(model.validateCredentials("","")).thenReturn(true);
        presenter.attemptLogin("","");

        verify(view, times(1)).showProgressBar();
        verify(view).loginSuccessful();
        verify(view, never()).loginFailed();
        verify(view, times(1)).hideProgressBar();
    }

    @Test
    public void attemptLogin_when_failed(){
        when(model.validateCredentials("","")).thenReturn(false);
        presenter.attemptLogin("","");

        verify(view, times(1)).showProgressBar();
        verify(view, never()).loginSuccessful();
        verify(view, times(1)).loginFailed();
        verify(view, times(1)).hideProgressBar();
    }

}