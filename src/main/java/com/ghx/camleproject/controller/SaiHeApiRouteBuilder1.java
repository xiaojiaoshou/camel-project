package com.ghx.camleproject.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @name: ${name}
 * @description:
 * @type: JAVA
 * @since: 2020/8/11 14:17
 * @author: guohuixiang
 */
@Component
public class SaiHeApiRouteBuilder1 extends SpringRouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:meelermeeler")
                //.marshal().jacksonxml()
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("ccccccccccc");
                        Message in = exchange.getIn();
                        in.setHeader("Content-Type", "text/xml");
                        in.setHeader(Exchange.HTTP_METHOD, "POST");
                        String body = in.getBody(String.class);
                        System.out.println(body);

                    }
                })
                //.setHeader(Exchange.HTTP_METHOD, constant("POST"))
                //.setHeader(Exchange.CONTENT_TYPE, constant("text/xml"))
                .to("http://gg55.irobotbox.com/Api/API_Irobotbox_Orders.asmx?op=GetOrders")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String body = exchange.getMessage().getBody(String.class);
                      //  JSONObject jsonObject = JSONUtil.xmlToJson(body);
                        System.out.println(body);
                        exchange.getMessage().setBody(body);
                    }
                });



        from("direct:rest")
                //.marshal().jacksonxml()
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("ccccccccccc");
                        Message in = exchange.getIn();
                        in.setHeader("Content-Type", "text/xml");
                        in.setHeader(Exchange.HTTP_METHOD, "POST");
                        String body = in.getBody(String.class);
                        System.out.println(body);

                    }
                })
                //.setHeader(Exchange.HTTP_METHOD, constant("POST"))
                //.setHeader(Exchange.CONTENT_TYPE, constant("text/xml"))
                .to("http://gg55.irobotbox.com/Api/API_Irobotbox_Orders.asmx?op=GetOrders&bridgeEndpoint=true");
    }

//    @Override
//    public void configure() throws Exception {
//        from("direct:meelermeeler").process(new Processor() {
//            @Override
//            public void process(Exchange exchange) throws Exception {
//                Message in = exchange.getIn();
//                in.setHeader("Content-Type", "text/xml");
//                in.setHeader(Exchange.HTTP_METHOD, "POST");
//                Object body = in.getBody();
//                System.out.println(body);
//            }
//        }).to("http://gg55.irobotbox.com/Api/API_Irobotbox_Orders.asmx?op=GetOrders")
//                .process(exchange -> {
//                    String body = exchange.getMessage().getBody(String.class);
//                    JSONObject jsonObject = JSONUtil.xmlToJson(body);
//                    System.out.println(jsonObject.toStringPretty());
//                    exchange.getMessage().setBody(jsonObject);
//                });
////                .marshal().xmljson();
//    }


}
