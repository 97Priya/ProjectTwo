package com.projecttwo.digitalkitchen.service;


import com.projecttwo.digitalkitchen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecutiryService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.projecttwo.digitalkitchen.model.User> optional = userRepository.findById(username);
        com.projecttwo.digitalkitchen.model.User dbUser = optional.orElseThrow(() -> new UsernameNotFoundException(username));

        String[] authorities=dbUser
                .getAuthorities()
                .stream()
                .toArray(String[]::new);

        User user =new User(dbUser.getEmail(),dbUser.getPassword(), AuthorityUtils.createAuthorityList(authorities));

        return user;
    }
}
