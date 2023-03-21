package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public DiscapUser updateUserByFields(int id, Map<String, Object> fields) {
        Optional<DiscapUser> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(DiscapUser.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingUser.get(), value);
            });
            return userRepository.save(existingUser.get());
        }
        return null;
    }
}
