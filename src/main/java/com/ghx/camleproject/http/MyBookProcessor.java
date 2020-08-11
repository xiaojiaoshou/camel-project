package com.ghx.camleproject.http;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MyBookProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(String.format("bookId=%s,categoryId=%s", exchange.getIn().getHeader("bookId"), exchange.getIn().getHeader("categoryId")));
        exchange.getOut().setBody("<html><body>Book is good</body></html>");
    }
}
