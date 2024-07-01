package com.se.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConfigHelper {
    private static volatile ConfigHelper instance;
    private static String _url;

    private final Map<String, String> _configs;

    private ConfigHelper() {
        Dotenv env = Dotenv.configure()
                .directory("./")
                .filename("config.env")
                .load();

        Dotenv developmentEnv = Dotenv.configure()
                .directory("./")
                .filename("config-dev.env")
                .ignoreIfMissing()
                .load();

        _configs = new HashMap<>();

        env.entries().forEach(entry -> _configs.put(entry.getKey(), entry.getValue()));
        developmentEnv.entries().forEach(entry -> _configs.put(entry.getKey(), entry.getValue()));
    }

    public static ConfigHelper getInstance() {
        if (instance == null) {
            synchronized (ConfigHelper.class) {
                if (instance == null) {
                    instance = new ConfigHelper();
                }
            }
        }
        return instance;
    }

    public String getValue(String key) {
        if (!_configs.containsKey(key)) {
            throw new IllegalArgumentException(
                    "Environment & config files were missing the following required key: " + key);
        }
        return _configs.get(key);
    }

    // Add your specific getter methods here
    public String getApiRoot() {
        return getValue("API_ROOT");
    }

    public String getSubjectExpertUrl() {
        return getValue("SUBJECT_EXPERT_URL");
    }

    public String getStudentUsername() {
        return getValue("STUDENT_USERNAME");
    }

    public String getStudentPassword() {
        return getValue("STUDENT_PASSWORD");
    }

    public String getTeacherUsername() {
        return getValue("TEACHER_USERNAME");
    }

    public String getTeacherPassword() {
        return getValue("TEACHER_PASSWORD");
    }

    public String getNewUserFirstName() {
        return getValue("USER_FIRSTNAME");
    }

    public String getNewUserLastName() {
        return getValue("USER_LASTNAME");
    }

    public String getNewUserUsername() {
        return getValue("USER_USERNAME");
    }

    public String getNewUserPassword() {
        return getValue("USER_PASSWORD");
    }

    public String getNewUserEmail() {
        return getValue("USER_EMAIL");
    }

    public String getRecoveryEmail() {
        return getValue("RECOVERY_EMAIL");
    }

    public String getYahooUsername() {
        return getValue("YAHOO_USERNAME");
    }
    public String getYahooPassword() {
        return getValue("YAHOO_PASSWORD");
    }

    public String getNonSystemUserCustomerName() {
        return getValue("NON_SYSTEM_USER_ENTERPRISE_CUSTOMER_NAME");
    }

    public String getNonSystemUserAlarmProtocolName() {
        return getValue("NON_SYSTEM_USER_ALARM_PROTOCOL_NAME");
    }

    public String getSystemUserEnterpriseName() {
        return getValue("SYSTEM_USER_ENTERPRISE_NAME");
    }

    public String getSystemUserPassword() {
        return getValue("SYSTEM_USER_PASSWORD");
    }

    public String getSystemUserUsername() {
        return getValue("SYSTEM_USER_USERNAME");
    }

    public String getSystemUserCustomerName() {
        return getValue("SYSTEM_USER_ENTERPRISE_CUSTOMER_NAME");
    }

    public String getSystemUserAlarmProtocolName() {
        return getValue("SYSTEM_USER_ALARM_PROTOCOL_NAME");
    }

    public String getOtherNonSystemUserEnterpriseName() {
        return getValue("OTHER_NON_SYSTEM_USER_ENTERPRISE_NAME");
    }

    public String getOtherNonSystemUserPassword() {
        return getValue("OTHER_NON_SYSTEM_USER_PASSWORD");
    }

    public String getOtherNonSystemUserUsername() {
        return getValue("OTHER_NON_SYSTEM_USER_USERNAME");
    }

    public String getOtherNonSystemUserCustomerName() {
        return getValue("OTHER_NON_SYSTEM_USER_ENTERPRISE_CUSTOMER_NAME");
    }

    public String getOtherNonSystemUserAlarmProtocolName() {
        return getValue("OTHER_NON_SYSTEM_USER_ALARM_PROTOCOL_NAME");
    }

    public boolean shouldRunTestsHeadless() {
        return Boolean.parseBoolean(getValue("HEADLESS_TESTS"));
    }

    public String getTestObjectZone() {
        return getValue("TESTOBJECT_ZONE");
    }

    public String getTestObjectAccesskey() {
        return getValue("TESTOBJECT_ACCESSKEY");
    }

    public boolean shouldOpenBrowserConsole() {
        return Boolean.parseBoolean(getValue("BROWSER_DEBUG_ENABLED"));
    }

    public String getBrowser() {
        return getValue("BROWSER");
    }

    public String getBrowserVersion() {
        return getValue("BROWSER_VERSION");
    }

    public String getSeleniumEnv() {
        return getValue("SELENIUM_ENV");
    }

    public String getOsPlatform() {
        return getValue("PLATFORM");
    }

    public String getPlatformVersion() {
        return getValue("PLATFORM_VERSION");
    }

    public boolean isMobileTestingEnabled() {
        return Boolean.parseBoolean(getValue("MOBILE_TESTING_ENABLED"));
    }

    public String getSeleniumHub() {
        return getValue("SELENIUM_HUB");
    }

    public String getBrowserstackProject() {
        return getValue("BROWSERSTACK_PROJECT");
    }

    public void setTestObjectSeleniumHub() {
        final var zone = getTestObjectZone();

        if (zone.equals("Europe")) {
            _url = "https://eu1.appium.testobject.com/wd/hub";
        } else {
            _url = "https://us1.appium.testobject.com/wd/hub";
        }

        instance._configs.put("TESTOBJECT_SELENIUM_HUB", _url);
    }

    public boolean isWebInspectorEnabled() {
        return Boolean.parseBoolean(getValue("WEB_INSPECTOR_ENABLED"));
    }

    public boolean isServerLogCaptureEnabled() {
        return Objects.equals(getValue("ENABLE_SERVER_LOG_CAPTURE"), "true");
    }

    public int getMaxRetriesOnFailure() {
        return Integer.parseInt(getValue("FAIL_RETRIES"));
    }

    public int getTestInvocationCount() {
        return Integer.parseInt(getValue("TEST_INVOCATION_COUNT"));
    }

    public boolean isOverrideBrowserDefaultDownloadDirectoryEnabled() {
        return Objects.equals(getValue("OVERRIDE_BROWSER_DEFAULT_DOWNLOAD_DIRECTORY"), "true");
    }
}
