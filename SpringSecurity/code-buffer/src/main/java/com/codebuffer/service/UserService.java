package com.codebuffer.service;

import com.codebuffer.entity.User;
import com.codebuffer.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);
}
