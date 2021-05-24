package com.prana.financial.model.request;

import com.prana.financial.domain.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserVerification {

    @NotBlank
    @Size(min = 11, max = 11)
    @Pattern(regexp = "(^$|[0-9]{11})")
    private String username;
    @NotBlank
    private String verificationCode;
    @NotBlank
    private String password;


    public User convertModelToDomain(UserVerification userVerification){
        User user = new User();
        user.setUsername(userVerification.getUsername());
        user.setVerificationCode(userVerification.getVerificationCode());
        user.setPassword(userVerification.getPassword());
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
