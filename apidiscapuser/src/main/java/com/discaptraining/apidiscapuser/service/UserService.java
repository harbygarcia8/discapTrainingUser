package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;


    public List<DiscapUser> getAllUserPerson(){
        return userRepository.findDiscapUserList();
    }
    public List<DiscapUser> getUserByPersonId(int personId){
        return userRepository.findDiscapUser(personId);
    }

    public DiscapUser saveDiscapUser(DiscapUser bodyDiscapUsers){

        bodyDiscapUsers.setPassword(bcryptEncoder.encode(bodyDiscapUsers.getPassword()));
        return userRepository.save(bodyDiscapUsers);
    }

    public void deleteDiscapUser(int id){
        userRepository.deleteById(id);
    }


    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        DiscapUser user = userRepository.findByEmail(userEmail).get(0);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userEmail);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }


}



