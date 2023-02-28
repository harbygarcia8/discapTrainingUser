package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.User;
import com.discaptraining.apidiscapuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public User getUserByPersonId(int userID){
        return userRepository.findByPersonID(userID);
    }

}
