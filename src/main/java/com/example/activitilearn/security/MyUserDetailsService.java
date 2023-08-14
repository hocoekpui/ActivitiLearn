package com.example.activitilearn.security;


import com.example.activitilearn.mapper.UserInfoBeanMapper;
import com.example.activitilearn.pojo.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private UserInfoBeanMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = mapper.selectByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("user doest not exist");
        }
        return userInfo;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}