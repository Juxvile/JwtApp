package com.jwtproject.JwtApp.security;

import com.jwtproject.JwtApp.model.User;
import com.jwtproject.JwtApp.security.jwt.JwtUSerFactory;
import com.jwtproject.JwtApp.security.jwt.JwtUser;
import com.jwtproject.JwtApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public JwtUserDetailsService (UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        JwtUser jwtUser = JwtUSerFactory.create(user);
        log.info("IN loadByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}
