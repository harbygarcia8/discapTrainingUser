package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public List<DiscapUser> getAllUserPerson(){
        return userRepository.findDiscapUserList();
    }
    public List<DiscapUser> getUserByPersonId(int personId){
        return userRepository.findDiscapUser(personId);
    }

    public DiscapUser saveDiscapUser(DiscapUser bodyDiscapUsers){
        return userRepository.save(bodyDiscapUsers);
    }

    public void deleteDiscapUser(int id){
        userRepository.deleteById(id);
    }
}
