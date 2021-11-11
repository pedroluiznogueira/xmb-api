package com.xmbapi.services;

import com.xmbapi.model.User;
import com.xmbapi.model.UserLogin;
import com.xmbapi.repository.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User register(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }

    public UserLogin login(UserLogin userLogin){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Optional<User> user = userRepository.findByEmail(userLogin.getEmail());

        if (user.isPresent()) {

            if (encoder.matches(userLogin.getPassword(), user.get().getPassword())) {

                String auth = userLogin.getEmail() + ":" + userLogin.getPassword();

                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));

                String authHeader = "Basic " + new String(encodeAuth);

                userLogin.setToken(authHeader);

                return userLogin;
            }
        }
        return null;

    }

}
