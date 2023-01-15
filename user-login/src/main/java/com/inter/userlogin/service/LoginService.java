package com.inter.userlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inter.userlogin.model.Login;
import com.inter.userlogin.repository.LoginRepository;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Login login(String username, String password) {
        Login user = loginRepository.findByUsernameAndPassword(username, password);
        return user;
    }

}
