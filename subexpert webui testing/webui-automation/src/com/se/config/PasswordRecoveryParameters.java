package com.se.config;

import java.util.Objects;

public class PasswordRecoveryParameters {
    private final String email;
    private final String url;

    private PasswordRecoveryParameters(Builder builder) {
        this.email = builder.email;
        this.url = builder.url;
    }

    public String getEmail() {
        return email;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "PasswordRecovery{" +
                "email='" + email + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public static class Builder {
        private String email;
        private String url;

        public Builder() {
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public PasswordRecoveryParameters build() {
            return new PasswordRecoveryParameters(this);
        }
    }
}
