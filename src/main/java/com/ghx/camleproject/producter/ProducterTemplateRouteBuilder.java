package com.ghx.camleproject.producter;

import com.ghx.camleproject.entity.User;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducterTemplateRouteBuilder extends SpringRouteBuilder {

    @Autowired
    ProducerTemplate producerTemplate;
    @Autowired
    private Foo  foo;

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);// .bindingMode(RestBindingMode.json);


        //  bean方式调用方法
        rest("/producter")
                .get("/send")
                .to("direct:newproducter");


        from("direct:newproducter")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        User user = new User();
                        //Object result = producerTemplate.sendBody("direct:dd", ExchangePattern.InOut, user);
                        Object result = foo.doSomething();
                        exchange.getIn().setBody(result);
                    }
                });


    }
}
