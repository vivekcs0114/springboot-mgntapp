package com.synerzip.college.service;

import com.synerzip.college.model.CustomUserDetails;
import com.synerzip.college.model.User;
import com.synerzip.college.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserName(username);
        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUser
                .map(CustomUserDetails::new).get();
    }
}
