package com.ghx.camleproject.http;

import com.ghx.camleproject.entity.User;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ParamsRouteBuilder extends SpringRouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);// .bindingMode(RestBindingMode.json);


        /**
         * 测试header 参数设置默认值
         */
        rest("/customers")
                .get("/orders/{id}")
                .param().name("verbose").type(RestParamType.query).defaultValue("false").description("Verbose order details").endParam()
                .to("direct:customerOrders")
                .to("direct:dd");

        /**
         * 测试consumer 消费者
         */
        rest("/cusmer")
                .get("/dosomething")
                .to("direct:doSomething");

        from("direct:dd").process(new Processor() {

            @Override
            public void process(Exchange exchange) throws Exception {

                String verbose = exchange.getIn().getHeader("verbose", String.class);
                System.out.println("verbose=" + verbose);
                exchange.getIn().setBody(new User(1L, "张三ss", 23));
            }
        });


        /**
         *  对象接收请求参数
         */
        rest("/user")
                .get("/get")
                .type(User.class)
                .outType(User.class)
                .to("direct:newUser");
        from("direct:newUser").process(new Processor() {

            @Override
            public void process(Exchange exchange) throws Exception {
                String name = exchange.getIn().getHeader("name", String.class);
                System.out.println("name=" + name);
                exchange.getIn().setBody(new User(1L, "张三", 23));
            }
        });


    }
}
