package com.prana.financial.model.request;

import com.prana.financial.domain.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegister {

    @NotBlank
    @Size(min = 11, max = 11)
    @Pattern(regexp = "(^$|[0-9]{11})")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User convertModelToDomain(UserRegister userRegister){
        User user = new User();
        user.setUsername(userRegister.getUsername());
        return user;
    }
}
