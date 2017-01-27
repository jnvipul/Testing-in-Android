package com.example.vj.samplemvpandroid.login;

import org.junit.Before;
import org.junit.Test;

//import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by vJ on 1/27/17.
 */
public class EmailValidatorTest {
    public EmailValidatorTest() {
    }

    private EmailValidator validator;

    @Before
    public void setup(){
        validator = new EmailValidator();
    }

    @Test
    public void validate_shouldReturnNoErrorForValidEmails(){
        String sampleEmail = "messagevipul@gmail.com";
        Validator.ValidationResult result = validator.validate(sampleEmail);

        assert(result.equals(Validator.ValidationResult.NO_ERROR));
    }

    @Test
    public void validate_shouldReturnEmptyInputErrorForEmptyEmails(){
        String sampleEmail = "";
        Validator.ValidationResult result = validator.validate(sampleEmail);

        assert(result.equals(Validator.ValidationResult.EMPTY_INPUT_FIELD));

    }

    @Test
    public void validate_shouldReturnEmptyInputErrorForNullEmails(){
        Validator.ValidationResult result = validator.validate(null);

        assert(result.equals(Validator.ValidationResult.EMPTY_INPUT_FIELD));

    }


}