package com.discaptraining.apidiscapuser.security;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DiscapUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        DiscapUser user = userRepository.findDiscapUser()
        return new User("discap@gmail.com", "{noop}admin", new ArrayList<>());
    }

    public DiscapUser saveUser(DiscapUser bodyDiscapUsers) {
        return userRepository.save(bodyDiscapUsers);
    }

}
