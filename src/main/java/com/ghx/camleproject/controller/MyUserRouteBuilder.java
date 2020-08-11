package com.ghx.camleproject.controller;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyUserRouteBuilder extends SpringRouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("direct:start").to("seda:userService");
//        from("direct:start")
//                .setHeader(Exchange.HTTP_METHOD, HttpMethods.GET)
//                .process(new UserProcessor());
    }
}
