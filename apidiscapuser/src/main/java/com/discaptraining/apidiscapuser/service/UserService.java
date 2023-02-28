package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public DiscapUser getUserByPersonId(int userID){
        return userRepository.findByPersonID(userID);
    }

}
