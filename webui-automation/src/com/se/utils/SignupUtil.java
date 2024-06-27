package com.se.utils;

import com.github.javafaker.Faker;
import com.se.TestDriver;
import com.se.config.Constants;

import com.se.config.SignupParameters;
import io.qameta.allure.Step;

import java.util.AbstractMap;
import java.util.stream.Stream;

import static com.se.utils.UtilsSet.*;

public class SignupUtil {
    public static void signUp(SignupParameters signupParameters) {


        signup(
                signupParameters.getFirstName(),
                signupParameters.getLastName(),
                signupParameters.getUsername(),
                signupParameters.getPassword(),
                signupParameters.getEmail()
        );
    }
    public static void signup(
            String firstName,
            String lastName,
            String username,
            String password,
            String email
    ) {
        clickOnElement(Constants.Signup.BY_Signup_button);
        Stream.of(
                        new AbstractMap.SimpleEntry<>(Constants.Signup.BY_firstname, firstName),
                        new AbstractMap.SimpleEntry<>(Constants.Signup.BY_lastname, lastName),
                        new AbstractMap.SimpleEntry<>(Constants.Signup.BY_username, username),
                        new AbstractMap.SimpleEntry<>(Constants.Signup.BY_password, password),
                        new AbstractMap.SimpleEntry<>(Constants.Signup.BY_confirmpassword, password),
                        new AbstractMap.SimpleEntry<>(Constants.Signup.BY_email, email)

                        )
                .forEach(entry -> {
                    if (entry.getValue() != null) {
                        clearAndSetElementText(entry.getKey(), entry.getValue());
                        return;
                    }

                    // Trigger the "field required" message
                    sendTextToElement(
                            entry.getKey(),
                            Faker.instance().lorem().characters()
                    );
                    clearTextArea(entry.getKey());
                });

        clickOnElement(Constants.Signup.By_submit_Button);

    }



    @Step
    public static void goToLoginPage(SignupParameters signupParameters) {
        goToUrl(signupParameters.getUrl());
    }

}
