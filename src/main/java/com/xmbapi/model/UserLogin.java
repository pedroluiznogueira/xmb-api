package com.xmbapi.model;

import java.util.Objects;

public class UserLogin {

    private String email;
    private String token;
    private String password;

    public UserLogin() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLogin userLogin = (UserLogin) o;
        return Objects.equals(email, userLogin.email) && Objects.equals(password, userLogin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}