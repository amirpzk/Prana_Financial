package com.prana.financial.service.interfaces;

import com.prana.financial.domain.User;

public interface UserService {
    User findByUsername(String username);

    User register(User user);

    boolean verify(User user);

    User forgetPassword(User user);

    boolean userChangePasswordDuringForgetPassword(User user);

    boolean changePassword(String username, String lastPassword, String newPassword);

    String login(String username, String password);

    boolean regenerateVerificationCode(User user);
}
