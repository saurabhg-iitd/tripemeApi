package com.tripeme.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripeme.api.bo.User;
import com.tripeme.api.repository.UserRepository;
import com.tripeme.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


	@Override
	public User findByUserId(Long userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public User findByEmailId(String emailId) {
		return userRepository.findByEmailId(emailId);
	}


}
