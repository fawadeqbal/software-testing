package com.se.config;

import java.util.Objects;

public class LoginParameters {
    private final String _Url;
    private final Constants.Role _role;
    private Boolean _hasMoreThanOneRole = true;
    private final String _password;
    private final String _username;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var that = (LoginParameters) o;
        return _role == that._role
                && Objects.equals(_password, that._password)
                && Objects.equals(_username, that._username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_role, _password, _username);
    }

    public static class Builder {
        private String _Url;
        private Constants.Role _role;
        private String _password;
        private String _username;

        public Builder() {
        }

        public Builder(LoginParameters loginParameters) {
            _Url = loginParameters.getUrl();
            _role = loginParameters.getRole();
            _password = loginParameters.getPassword();
            _username = loginParameters.getUsername();
        }

        public LoginParameters build() {
            return new LoginParameters(this);
        }

        public Builder role(Constants.Role role) {
            _role = role;
            return this;
        }

        public Builder getUrl(String intelliTrackUrl) {
            _Url = intelliTrackUrl;
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
    }

    private LoginParameters(Builder builder) {
        _role = builder._role;
        _Url = builder._Url;
        _password = builder._password;
        _username = builder._username;
    }


    public Boolean getHasMoreThanOneRole() {
        return _hasMoreThanOneRole;
    }

    public String getApiRootUrl() {
        return ConfigHelper.getInstance().getApiRoot();
    }

    public Constants.Role getRole() {
        return _role;
    }
    public String getUrl() {
        return _Url;
    }

    public String getUsername() {
        return _username;
    }

    public String getPassword() {
        return _password;
    }


}