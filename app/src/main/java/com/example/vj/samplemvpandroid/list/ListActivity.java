package com.example.vj.samplemvpandroid.list;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.vj.samplemvpandroid.ApplicationState;
import com.example.vj.samplemvpandroid.base.BaseActivity;
import com.example.vj.samplemvpandroid.R;
import com.example.vj.samplemvpandroid.model.Repository;
import com.example.vj.samplemvpandroid.utility.ServiceGenerator;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class ListActivity extends BaseActivity implements IListActivityView, AdapterView.OnItemClickListener {

    @BindView(R.id.list)
    ListView listView;

    @BindView(R.id.progressBar)
    ProgressBar progressbar;

    ListPresenter presenter;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setup();
    }

    private void setup() {
        ButterKnife.bind(this);

        // Dagger
        ((ApplicationState) getApplication()).getApplicationComponent().inject(this);

        presenter = new ListPresenter(this, ServiceGenerator.getGithubService(retrofit));
        presenter.attachView(this);
        presenter.loadRepositories();
    }

    @Override
    public void onRepositoryLoadSuccess(List<Repository> list) {
        Log.v("Repository Load", new Gson().toJson(list));
        listView.setAdapter(new RepositoryListAdapter(list, this));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onRepositoryLoadFailure(Throwable error) {
        Log.v("Repository Load Failed", error.getMessage());
    }

    @Override
    public void showProgressBar() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressbar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Repository repository = (Repository) adapterView.getAdapter().getItem(i);
        showToast(repository.getName());
    }
}
