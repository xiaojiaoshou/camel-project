package com.ghx.camleproject.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu")
public class UserController {

    @Autowired
    ProducerTemplate producerTemplate;


    @RequestMapping("/get")
    public Object getUser() {
        return "哈哈";
    }

    @RequestMapping("/send")
    public Object sendproducter() {
        return null;
    }
}
