package com.example.vj.samplemvpandroid.login;

/**
 * Created by vJ on 1/27/17.
 */

public interface Validator {
    enum ValidationResult{
        NO_ERROR,
        EMPTY_INPUT_FIELD
    }

    ValidationResult validate(String string);
}
