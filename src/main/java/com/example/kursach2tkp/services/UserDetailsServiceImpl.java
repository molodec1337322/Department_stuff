package com.example.kursach2tkp.services;

import com.example.kursach2tkp.dao.UserDAO;
import com.example.kursach2tkp.models.User;
import com.example.kursach2tkp.models.enums.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{

        User user = userDAO.getUserByLogin(login);
        UserBuilder builder = null;
        if (user != null){

            builder = org.springframework.security.core.userdetails.User.withUsername(login);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            builder.roles(UserRoleEnum.USER.name());

            return builder.build();
        }
        throw new UsernameNotFoundException("UserNotFound");
    }
}
