package com.prana.financial.service.implementations;

import com.prana.financial.domain.User;
import com.prana.financial.exception.*;
import com.prana.financial.jwt.JwtFactory;
import com.prana.financial.repository.UserRepository;
import com.prana.financial.service.interfaces.UserService;
import com.prana.financial.sms.SmsComponent;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtFactory jwtFactory;
    @Autowired
    private Environment env;

    private final Logger logger = Logger.getLogger(UserServiceImp.class.getSimpleName());


    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User register(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            User founded = repository.findByUsername(user.getUsername());
            if (founded.isVerified())
                throw new VerifiedUserWithThisUsernameExist();
            throw new UnVerifiedUserWithThisUsernameExist();
        }
        user.setVerificationCode(RandomString.make(5));
        user.setVerificationCodeDate(new Date());
        user.setVerified(false);
        User saved = repository.save(user);
        new SmsComponent(env).sendMessage(saved.getUsername(), generateMessage("sign-up-verification-code", user.getVerificationCode()));
        return saved;
    }


    @Override
    public boolean regenerateVerificationCode(User user) {
        if (!repository.existsByUsername(user.getUsername()))
            throw new UserNotFound();
        User founded = repository.findByUsername(user.getUsername());
        if (founded.isVerified())
            throw new VerifiedUserWithThisUsernameExist();
        founded.setVerificationCodeDate(new Date());
        founded.setVerificationCode(RandomString.make(5));
        founded.setVerified(false);
        repository.save(founded);
        new SmsComponent(env).sendMessage(founded.getUsername(), generateMessage("regenerate-verification-code", founded.getVerificationCode()));
        return true;
    }

    @Override
    public boolean verify(User user) {
        if (!repository.existsByUsername(user.getUsername()))
            throw new UserNotFound();
        User founded = repository.findByUsername(user.getUsername());
        if (founded.isVerified())
            throw new VerifiedUserWithThisUsernameExist();
        if (founded.getVerificationCodeDate().compareTo(new Date()) > 3600000)
            throw new VerificationCodeExpired();
        if (!founded.getVerificationCode().equals(user.getVerificationCode()))
            throw new WrongVerificationCoe();
        founded.setVerificationCode(null);
        founded.setVerified(true);
        founded.setVerificationCodeDate(null);
        founded.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(founded);
        return true;
    }

    @Override
    public User forgetPassword(User user) {
        if (!repository.existsByUsername(user.getUsername()))
            throw new UserNotFound();
        User founded = repository.findByUsername(user.getUsername());
        if (!founded.isVerified())
            throw new UnVerifiedUserWithThisUsernameExist();
        founded.setForgetPasswordCode(RandomString.make(5));
        founded.setForgetPasswordCodeDate(new Date());
        User saved = repository.save(founded);
        new SmsComponent(env).sendMessage(saved.getUsername(), generateMessage("forget-password-code", saved.getForgetPasswordCode()));
        return saved;
    }

    @Override
    public boolean userChangePasswordDuringForgetPassword(User user) {
        if (!repository.existsByUsername(user.getUsername()))
            throw new UserNotFound();
        User founded = repository.findByUsername(user.getUsername());
        if (!founded.isVerified())
            throw new UnVerifiedUserWithThisUsernameExist();
        if (founded.getForgetPasswordCodeDate().compareTo(new Date()) > 3600000)
            throw new ForgetPasswordCodeExpired();
        if (!founded.getForgetPasswordCode().equals(user.getForgetPasswordCode()))
            throw new WrongForgetPasswordCode();
        founded.setPassword(passwordEncoder.encode(user.getPassword()));
        founded.setForgetPasswordCode(null);
        founded.setForgetPasswordCodeDate(null);
        repository.save(founded);
        return true;
    }

    @Override
    public boolean changePassword(String username, String lastPassword, String newPassword) {
        if (!repository.existsByUsername(username))
            throw new UserNotFound();
        User founded = repository.findByUsername(username);
        if (!founded.isVerified())
            throw new UnVerifiedUserWithThisUsernameExist();
        if (!passwordEncoder.matches(founded.getPassword(), lastPassword))
            throw new WrongChangePasswordAuthenticate();
        founded.setPassword(passwordEncoder.encode(newPassword));
        repository.save(founded);
        return true;
    }

    @Override
    public String login(String username, String password) {
        if (!repository.existsByUsername(username))
            throw new UserNotFound();
        User founded = repository.findByUsername(username);
        if (!founded.isVerified())
            throw new UnVerifiedUserWithThisUsernameExist();
        if (!passwordEncoder.matches(password, founded.getPassword()))
            throw new UserWrongPassword();
        String token = jwtFactory.generateToken(username);
        return token;
    }

    private String generateMessage(String type, String generatedCode) {
        String message = null;
        String inFileMessage = null;
        if (type.equals("sign-up-verification-code")) {
            inFileMessage = "\nکد فعالسازی حساب کاربری شما در نرم افزار مالی پرانا:\n";
        }
        if (type.equals("regenerate-verification-code")) {
            inFileMessage = "\nکد فعالسازی حساب کاربری شما در نرم افزار مالی پرانا:\n";
        }
        if (type.equals("forget-password-code")) {
            inFileMessage = "\nکد تایید شما در بخش فراموشی رمز عبور در نرم افزار مالی پرانا :\n";
        }
        message = inFileMessage + "\n" + generatedCode;
        return message;
    }
}
