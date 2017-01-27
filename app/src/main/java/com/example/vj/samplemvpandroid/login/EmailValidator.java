package com.example.vj.samplemvpandroid.login;

import android.text.TextUtils;

/**
 * Created by vJ on 1/27/17.
 */

public class EmailValidator implements Validator{

    @Override
    public ValidationResult validate(String string) {
        if(string == null || string.isEmpty()){
            return ValidationResult.EMPTY_INPUT_FIELD;
        }
        return ValidationResult.NO_ERROR;
    }
}
