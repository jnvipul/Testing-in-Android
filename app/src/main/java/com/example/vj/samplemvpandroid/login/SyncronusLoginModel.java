package com.example.vj.samplemvpandroid.login;

/**
 * Created by vJ on 1/18/17.
 */

public class SyncronusLoginModel implements ILoginModel {
    @Override
    public boolean validateCredentials(String username, String password) {
        if (username.contains("g")) {
            return true;
        }
        return false;
    }
}
