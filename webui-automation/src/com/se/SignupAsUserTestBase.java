package com.se;

import com.se.config.SignupParameters;
import io.qameta.allure.Allure;
import org.testng.annotations.BeforeMethod;

public class SignupAsUserTestBase extends TestBase{
    protected final SignupParameters _signupParameters;
    private boolean _hasLaunched;

    protected SignupAsUserTestBase(
            SignupParameters signupParameters,
            boolean tearDownBrowserAfterEachTest
    ) {
        super(tearDownBrowserAfterEachTest);
        _signupParameters = signupParameters;
    }
    @BeforeMethod( alwaysRun = true )
    public void launchSubjectExpertAndSignup() {
        if ((_tearDownBrowserAfterEachTest || !_hasLaunched)) {
            _hasLaunched = true;
            launchSubjectExpertAndSignup(_signupParameters);
        } else {
            Allure.step("skip login");
        }
    }
}
