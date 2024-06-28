package com.se.config;

import java.util.Objects;

public class SignupParameters {
    private final String _Url;
    private Boolean _hasMoreThanOneRole = true;
    private final String _password;
    private final String _username;
    private final String _firstName;
    private final String _email;

    private final String _lastName;

    public static class Builder {
        private String _Url;
        private String _password;
        private String _username;
        private String _firstName;
        private String _email;

        private String _lastName;
        public Builder() {
        }

        public Builder(SignupParameters signupParameters) {
            _Url = signupParameters.getUrl();
            _firstName=signupParameters.getFirstName();
            _lastName=signupParameters.getLastName();
            _username = signupParameters.getUsername();
            _password = signupParameters.getPassword();
            _email=signupParameters.getEmail();


        }

        public SignupParameters build() {
            return new SignupParameters(this);
        }

        public Builder getUrl(String intelliTrackUrl) {
            _Url = intelliTrackUrl;
            return this;
        }
        public Builder firstName(String firstName) {
            _firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            _lastName = lastName;
            return this;
        }

        public Builder password(String password) {
            _password = password;
            return this;
        }

        public Builder username(String username) {
            _username = username;
            return this;
        }

        public Builder email(String email) {
            _email = email;
            return this;
        }
    }

    private SignupParameters(Builder builder) {
        _Url = builder._Url;
        _firstName=builder._firstName;
        _lastName=builder._lastName;
        _username = builder._username;
        _password = builder._password;
        _email=builder._email;
    }


    public Boolean getHasMoreThanOneRole() {
        return _hasMoreThanOneRole;
    }

    public String getApiRootUrl() {
        return ConfigHelper.getInstance().getApiRoot();
    }

    public String getUrl() {
        return _Url;
    }
    public String getFirstName(){return _firstName;}
    public String getLastName(){return _lastName;}
    public String getUsername() {
        return _username;
    }
    public String getPassword() {
        return _password;
    }
    public String getEmail(){return _email;}
}