package com.example.vj.samplemvpandroid.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.vj.samplemvpandroid.R;
import com.example.vj.samplemvpandroid.base.BaseActivity;
import com.example.vj.samplemvpandroid.list.ListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.usernameET)
    EditText usernameET;

    @BindView(R.id.passwordET)
    EditText passwordET;

    @BindView(R.id.progressBar)
    ProgressBar progressbar;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        presenter = new LoginPresenter(new SyncronusLoginModel());
        presenter.attachView(this);
    }

    @Override
    public void loginFailed() {
        showToast(getString(R.string.login_failed));
    }

    @Override
    public void loginSuccessful() {
        showToast(getString(R.string.login_successful));
        startActivity(new Intent(this, ListActivity.class));
    }

    @Override
    public void showProgressBar() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressbar.setVisibility(View.GONE);
    }

    @OnClick(R.id.login_button)
    public void onLogin(View view){
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();

        presenter.attemptLogin(username, password);
    }
}
