package com.example.vj.samplemvpandroid.list;

import com.example.vj.samplemvpandroid.model.Repository;
import com.example.vj.samplemvpandroid.retrofit_services.GithubService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Created by vJ on 1/29/17.
 */
public class ListModelTest {

    @Mock
    GithubService githubService;

    @Mock
    Call<List<Repository>> call;


    ListModel model;

    String username = "";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        model = new ListModel(githubService);
    }

    @Test
    public void getRepositories_calls(){
        model.getRepositories(username);
        verify(githubService).listRepos(username);
    }
}