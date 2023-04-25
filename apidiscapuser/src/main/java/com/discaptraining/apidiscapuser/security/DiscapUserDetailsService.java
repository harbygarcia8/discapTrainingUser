package com.discaptraining.apidiscapuser.security;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DiscapUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<DiscapUser> user = userRepository.findDiscapUserByEmail(username);

        if(user.isPresent()) return new User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
        else return null;

    }

    public DiscapUser saveUser(DiscapUser bodyDiscapUsers) {

        bodyDiscapUsers.setPassword(bcryptEncoder.encode(bodyDiscapUsers.getPassword()));
        return userRepository.save(bodyDiscapUsers);
    }

}
