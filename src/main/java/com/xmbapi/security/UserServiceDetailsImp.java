package com.xmbapi.security;

import com.xmbapi.model.User;
import com.xmbapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceDetailsImp implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> user = this.userRepository.findByEmail(email);
        user
                .orElseThrow(
                        () -> new UsernameNotFoundException(user + "not found")
                );
        return user.map(UserDetailsImp::new).get();
    }

}