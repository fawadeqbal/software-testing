package com.se.tests.smoke;

import com.github.javafaker.Faker;
import com.se.base.PasswordRecoveryBase;
import com.se.config.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.AbstractMap;
import java.util.stream.Stream;

import static com.se.utils.UtilsSet.*;

public class PasswordRecoveryTest extends PasswordRecoveryBase {
    @Test
    public void verifyPasswordRecovery(){
        clickOnElement(Constants.Login.BY_LOG_OFF);
        clickOnElement(Constants.Login.BY_login);
        clickOnElementOnceClickable(Constants.PasswordRecovery.By_Forgot_Password_Button);
        Stream.of(
                        new AbstractMap.SimpleEntry<>(Constants.PasswordRecovery.By_email,Constants.PASSWORD_RECOVERY_DETAILS.getEmail())
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
        clickOnElement(Constants.PasswordRecovery.By_request_credentials);

        Assert.assertEquals("Success!",getElementText(Constants.PasswordRecovery.By_success_label));
    }
}
