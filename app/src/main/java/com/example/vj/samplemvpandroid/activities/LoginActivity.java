package com.example.vj.samplemvpandroid.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.vj.samplemvpandroid.R;
import com.example.vj.samplemvpandroid.login.ILoginView;
import com.example.vj.samplemvpandroid.login.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.usernameET)
    EditText usernameET;

    @BindView(R.id.passwordET)
    EditText passwordET;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setup();
    }

    private void setup() {
        presenter = new LoginPresenter(this);
    }

    @Override
    public void loginFailed() {
        showToast(getString(R.string.login_failed));
    }

    @Override
    public void loginSuccessful() {
        showToast(getString(R.string.login_successful));
    }

    @OnClick(R.id.login_button)
    public void onLogin(View view){
        String username = usernameET.getText().toString();
        String password = passwordET.getText().toString();

        presenter.attemptLogin(username, password);
    }
}
