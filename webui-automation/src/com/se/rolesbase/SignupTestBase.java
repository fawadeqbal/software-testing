package com.se.rolesbase;

import com.se.SignupAsUserTestBase;
import com.se.config.Constants;

public class SignupTestBase extends SignupAsUserTestBase {
    public SignupTestBase() {
        this(false);
    }

    public SignupTestBase(boolean tearDownBrowserAfterEachTest) {
        super(Constants.USER_SIGNUP_DETAILS, tearDownBrowserAfterEachTest);
    }
}
