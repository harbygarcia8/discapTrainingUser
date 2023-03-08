package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======

>>>>>>> master

import java.util.List;

@Service
public class UserService {

<<<<<<< HEAD
    public List<DiscapUser> getAllUsers(){
        return (List<DiscapUser>) userRepository.findAll();
    }
    @Autowired
    private IUserRepository userRepository;

    public DiscapUser getUserById(int id){
        return userRepository.findById(id);
    }

    public DiscapUser getUserByPersonId(int userId){
        return userRepository.findByPersonId(userId);
    }

    public DiscapUser getUserByEmail(String email) {
        return userRepository.findByEmail(email);
=======
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
>>>>>>> master
    }

    public ResponseEntity<Object> updateUserById(Integer id) {
        ResponseEntity<Object> response = null;
        if (userRepository.existsById(id)) {
            DiscapUser usuario = new DiscapUser();
            userRepository.save(usuario);
            response = ResponseEntity.ok(HttpStatus.OK);
        }
        return response;
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

}
