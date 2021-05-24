package com.prana.financial.model.request;

import com.prana.financial.domain.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForgetThenChangePassword {

    @NotBlank
    @Size(min = 11, max = 11)
    @Pattern(regexp = "(^$|[0-9]{11})")
    private String username;
    @NotBlank
    private String forgetPasswordCode;
    @NotBlank
    private String password;

    public User convertModelToDomain(UserForgetThenChangePassword userForgetThenChangePassword){
        User user = new User();
        user.setUsername(userForgetThenChangePassword.getUsername());
        user.setForgetPasswordCode(userForgetThenChangePassword.getForgetPasswordCode());
        user.setPassword(userForgetThenChangePassword.getPassword());
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getForgetPasswordCode() {
        return forgetPasswordCode;
    }

    public void setForgetPasswordCode(String forgetPasswordCode) {
        this.forgetPasswordCode = forgetPasswordCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
