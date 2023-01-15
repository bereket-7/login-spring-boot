package com.inter.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inter.userlogin.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

    public Login findByUsernameAndPassword(String username, String password);

}
