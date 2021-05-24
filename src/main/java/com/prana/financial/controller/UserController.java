package com.prana.financial.controller;

import com.prana.financial.domain.User;
import com.prana.financial.exception.UserBadRequest;
import com.prana.financial.model.request.*;
import com.prana.financial.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Binding;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody UserRegister userRegister, BindingResult result){
        if ( result.hasErrors())
            throw new UserBadRequest();
        service.register( new UserRegister().convertModelToDomain(userRegister) );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/regenerate-verification-code")
    public ResponseEntity<Void> regenerateVerificationCode(@Valid @RequestBody UserRegister userRegister, BindingResult result){
        if ( result.hasErrors())
            throw new UserBadRequest();
        service.regenerateVerificationCode( new UserRegister().convertModelToDomain(userRegister) );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<Void> verify(@Valid @RequestBody UserVerification userVerification, BindingResult result){
        if ( result.hasErrors() )
            throw new UserBadRequest();
        service.verify(new UserVerification().convertModelToDomain(userVerification));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/forget-password")
    public ResponseEntity<Void> forgetPassword(@Valid @RequestBody UserForgetPassword userForgetPassword, BindingResult result){
        if ( result.hasErrors() )
            throw new UserBadRequest();
        service.forgetPassword(new UserForgetPassword().convertModelToDomain(userForgetPassword));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/forget-password/change-password")
    public ResponseEntity<Void> changePasswordDuringForgetPassword(@Valid @RequestBody UserForgetThenChangePassword userForgetThenChangePassword, BindingResult result){
        if ( result.hasErrors() )
            throw new UserBadRequest();
        service.userChangePasswordDuringForgetPassword(new UserForgetThenChangePassword().convertModelToDomain(userForgetThenChangePassword));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@Valid @RequestBody UserChangePassword userChangePassword, BindingResult result){
        if ( result.hasErrors() )
            throw new UserBadRequest();
        service.changePassword(userChangePassword.getUsername(), userChangePassword.getLastPassword(), userChangePassword.getNewPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLogin userLogin, BindingResult result){
        if ( result.hasErrors() )
            throw new UserBadRequest();
        String token = service.login(userLogin.getUsername(), userLogin.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
