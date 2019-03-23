package com.tripeme.api.service;

import com.tripeme.api.bo.User;

public interface UserService {
    User save(User user);

    User findByUserId(Long userId);
    User findByEmailId(String emailId);
}
