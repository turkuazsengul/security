package com.okay.security.service;

import com.okay.security.constant.RoleConstants;
import com.okay.security.converter.UserConverter;
import com.okay.security.entity.Role;
import com.okay.security.entity.User;
import com.okay.security.model.UserDto;
import com.okay.security.repository.RoleRepository;
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
public class UserServiceImpl implements UserService {

    private UserConverter converter;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserConverter converter, UserRepository userRepository, RoleRepository roleRepository) {
        this.converter = converter;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return null;
        } else {
            kullaniciYetkilendirme(user);

            return converter.convertToDto(user);
        }
    }

    @Override
    public UserDto register(UserDto userDto) {
        User user = converter.convertToEntity(userDto);

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(roleRepository.findById(RoleConstants.ROLE_A_ID).get());
        user.setRoleList(roleList);

        // kullanıcı db kayıt ediliyor
        userRepository.save(user);

        kullaniciYetkilendirme(user);

        return converter.convertToDto(user);
    }

    private void kullaniciYetkilendirme(User user) {
        // authentication rolleri ayarlanıyor
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        user.getRoleList().stream().forEach(r -> grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getUsername(),
                        grantedAuthorities));
    }
}