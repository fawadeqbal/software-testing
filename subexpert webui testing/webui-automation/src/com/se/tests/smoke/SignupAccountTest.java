package com.se.tests.smoke;

import com.se.TestBase;
import com.se.config.Constants;
import com.se.utils.SignupUtil;
import org.testng.annotations.Test;


import static com.se.TestBase.launchSubjectExpertAndSignup;
import static com.se.utils.UtilsSet.launchBrowserAndUrl;

public class SignupAccountTest  {
    @Test
    public void verifyUserIsRegistered(){
        launchBrowserAndUrl(Constants.USER_SIGNUP_DETAILS.getUrl(),Constants.Tags.BY_BODY);
        SignupUtil.signUp(Constants.USER_SIGNUP_DETAILS);
        System.out.println("Signup successfull...........");
    }
}
