package br.com.five.tasks.user;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

    private String email;
    private String password;

    public LoginForm() {}

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

    public UsernamePasswordAuthenticationToken convertObject() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
