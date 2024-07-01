package com.se.base;

import com.se.TestBase;
import com.se.config.ConfigHelper;
import com.se.config.Constants;
import org.testng.annotations.BeforeMethod;

import static com.se.utils.UtilsSet.*;

public class PasswordRecoveryBase extends TestBase {

    @BeforeMethod
    public void launchBrowser(){
        launchBrowserAndUrl(ConfigHelper.getInstance().getSubjectExpertUrl(), Constants.Tags.BY_BODY);
    }
}
