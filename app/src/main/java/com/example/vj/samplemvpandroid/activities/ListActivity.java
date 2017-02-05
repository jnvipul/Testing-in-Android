package com.example.vj.samplemvpandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.vj.samplemvpandroid.ApplicationState;
import com.example.vj.samplemvpandroid.list.IListActivityView;
import com.example.vj.samplemvpandroid.R;
import com.example.vj.samplemvpandroid.list.ListPresenter;
import com.example.vj.samplemvpandroid.list.RepositoryListAdapter;
import com.example.vj.samplemvpandroid.model.Repository;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;

public class ListActivity extends BaseActivity implements IListActivityView, AdapterView.OnItemClickListener {

    @BindView(R.id.list)
    ListView listView;

    @BindView(R.id.progressBar)
    ProgressBar progressbar;

    ListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setup();
    }

    private void setup() {
        ButterKnife.bind(this);
        presenter = new ListPresenter(this, ((ApplicationState) getApplication()).getGithubService());
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Repository repository = (Repository) adapterView.getAdapter().getItem(i);
        showToast(repository.getName());
    }
}
