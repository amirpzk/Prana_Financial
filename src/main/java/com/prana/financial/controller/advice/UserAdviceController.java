package com.prana.financial.controller.advice;

import com.prana.financial.exception.*;
import com.prana.financial.model.message.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class UserAdviceController {

    private final Logger logger = Logger.getLogger(UserAdviceController.class.getSimpleName());

    @Autowired
    private Environment e;

    @ExceptionHandler(VerifiedUserWithThisUsernameExist.class)
    public ResponseEntity<ErrorMessage> userWithThisUsernameExists(VerifiedUserWithThisUsernameExist e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("verified-user-with-this-username-exists")).setStatus(Status.VERIFIED_USER_WITH_THIS_USERNAME_EXISTS),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UnVerifiedUserWithThisUsernameExist.class)
    public ResponseEntity<ErrorMessage> unVerifiedUserWithThisUsernameExists(UnVerifiedUserWithThisUsernameExist e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("un-verified-user-with-this-username-exists")).setStatus(Status.UN_VERIFIED_USER_WITH_THIS_USERNAME_EXISTS),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorMessage> userNotFound(UserNotFound e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("user-not-found")).setStatus(Status.USER_NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VerificationCodeExpired.class)
    public ResponseEntity<ErrorMessage> verificationCodeExpired(VerificationCodeExpired e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("verification-code-expired")).setStatus(Status.VERIFICATION_CODE_EXPIRED),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(WrongVerificationCoe.class)
    public ResponseEntity<ErrorMessage> wrongVerificationCode(WrongVerificationCoe e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("wrong-verification-code")).setStatus(Status.WRONG_VERIFICATION_CODE),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UserBadRequest.class)
    public ResponseEntity<ErrorMessage> userBadRequest(UserBadRequest e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("user-bad-request")).setStatus(Status.USER_BAD_REQUEST),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForgetPasswordCodeExpired.class)
    public ResponseEntity<ErrorMessage> forgetPasswordCodeExpired(ForgetPasswordCodeExpired e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("forget-password-code-expired")).setStatus(Status.FORGET_PASSWORD_CODE_EXPIRED),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(WrongForgetPasswordCode.class)
    public ResponseEntity<ErrorMessage> wrongForgetPasswordCode(WrongForgetPasswordCode e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("wrong-forget-password-code")).setStatus(Status.WRONG_FORGET_PASSWORD_CODE),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(WrongChangePasswordAuthenticate.class)
    public ResponseEntity<ErrorMessage> wrongChangePasswordAuthenticate(WrongChangePasswordAuthenticate e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("wrong-change-password-authenticate")).setStatus(Status.WRONG_CHANGE_PASSWORD_AUTHENTCATE),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UserWrongPassword.class)
    public ResponseEntity<ErrorMessage> userWrongPassword(UserWrongPassword e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("user-wrong-password")).setStatus(Status.WRONG_USER_PASSWORD),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(TokenNotValidateWithThisSecretPass.class)
    public ResponseEntity<ErrorMessage> wrongSecretPass(TokenNotValidateWithThisSecretPass e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("token-not-validet-with-this-secret-pass")).setStatus(Status.SMS_NOT_SEND),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(SmsNotSent.class)
    public ResponseEntity<ErrorMessage> smsNotSent(SmsNotSent e) {
        logger.log(Level.INFO, e.getMessage());
        return new ResponseEntity<>(new ErrorMessage().setDate(new Date()).
                setMessage(this.e.getProperty("sms-not-sent")).setStatus(Status.TOKEN_NOT_VALIDATED_WITH_THIS_SECRET_PASS),
                HttpStatus.FORBIDDEN);
    }
}
