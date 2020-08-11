package com.ghx.camleproject.http;

import com.ghx.camleproject.entity.Student;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class HttpRouteBuilder extends SpringRouteBuilder {

    private String path;

    private String url;

    @Override
    public void configure() throws Exception {
        //from("servlet:http://127.0.0.1:8080/camel/service/hello").process(new MyBookProcessor());

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);// .bindingMode(RestBindingMode.json);

        rest("/say")
                .get("/hello").to("direct:hello")
                .get("/bye").consumes("application/json")
                .to("direct:bye")
                .post("/bye").to("mock:update");

        from("direct:hello")
                .transform().constant("Hello World");
        from("direct:bye")
                .transform().constant("Bye World");


        from("direct:records")
                .process(new Processor() {

                    final AtomicLong counter = new AtomicLong();

                    @Override
                    public void process(Exchange exchange) throws Exception {

                        final String name = exchange.getIn().getHeader("name", String.class);
                        exchange.getIn().setBody(new Student(counter.incrementAndGet(), name, "Camel + SpringBoot"));
                    }
                });


    }
}
