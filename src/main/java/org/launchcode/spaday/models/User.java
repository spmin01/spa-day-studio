package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message = "Username must not be blank.")
    @Size(min = 3, max = 12, message = "Username must be between 3 and 12 characters!")
    private String username;

    @Email(message = "Must Enter a valid email address!")
    private String email;

    @NotBlank(message = "Please enter a password.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

    @NotNull(message = "Passwords do not match!")
    private String verifyPassword;

    public User() {}

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if(!this.password.equals(this.verifyPassword)) {
            this.verifyPassword = null;
        }
    }
}
