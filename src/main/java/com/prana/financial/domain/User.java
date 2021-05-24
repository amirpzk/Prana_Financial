package com.prana.financial.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "verificationCode")
    private String verificationCode;
    @Column(name = "verification_code_date")
    private Date verificationCodeDate;
    @Column(name = "is_verified")
    private boolean isVerified;
    @Column(name = "forget_password_code")
    private String forgetPasswordCode;
    @Column(name = "forget_password_code_date")
    private Date forgetPasswordCodeDate;

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @PrePersist
    public void prePersist() {
        createdDate = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Date getVerificationCodeDate() {
        return verificationCodeDate;
    }

    public void setVerificationCodeDate(Date verificationCodeDate) {
        this.verificationCodeDate = verificationCodeDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getForgetPasswordCode() {
        return forgetPasswordCode;
    }

    public void setForgetPasswordCode(String forgetPasswordCode) {
        this.forgetPasswordCode = forgetPasswordCode;
    }

    public Date getForgetPasswordCodeDate() {
        return forgetPasswordCodeDate;
    }

    public void setForgetPasswordCodeDate(Date forgetPasswordCodeDate) {
        this.forgetPasswordCodeDate = forgetPasswordCodeDate;
    }

    public void initiatePatch(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.verificationCode = user.getVerificationCode();
        this.verificationCodeDate = user.getVerificationCodeDate();
        this.forgetPasswordCode = user.forgetPasswordCode;
        this.forgetPasswordCodeDate = user.forgetPasswordCodeDate;
        preUpdate();
    }

    public void initiatePut(User user) {
        initiatePatch(user);
    }
}
