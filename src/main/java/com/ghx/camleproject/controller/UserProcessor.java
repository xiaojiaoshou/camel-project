package com.ghx.camleproject.controller;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class UserProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("hahaah ");
        exchange.getOut().setBody("<html><body>Book is good</body></html>");
    }
}
