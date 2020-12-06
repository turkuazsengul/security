package com.okay.security.service;

import com.okay.security.converter.UserConverter;
import com.okay.security.entity.User;
import com.okay.security.model.UserDto;
import com.okay.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationService {

    @Autowired
    private UserConverter converter;

    @Autowired
    private UserRepository userRepository;

    public UserDto login(String username, String password) {

        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return null;
        } else {
            // authentication rolleri ayarlanıyor
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            user.getRoleList().stream().forEach(r -> grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));

            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            username,
                            password,
                            grantedAuthorities));

            return converter.convertToDto(user);
        }
    }

    public void logut(String username) {
        //TODO remove authentication
    }
}