package com.ghx.camleproject.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {


    public String getUser(Long id) {
        System.out.println("传入的id=:" + id);
        return "zhang san";
    }
}
