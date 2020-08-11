package com.ghx.camleproject.saihe;

import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SaiHeApiRouteBuilder extends SpringRouteBuilder {


    @Override
    public void configure() throws Exception {


        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.xml);
                //.producerComponent("http4");


        rest("/getorders")
                .produces("application/xml")
                .post("/all")
//                .consumes("text/xml")
//               .produces("text/xml")
        .to("mock:result");
               // .to("")
               //.to("http:gg55.irobotbox.com/Api/API_Irobotbox_Orders.asmx?bridgeEndpoint=true&op=GetOrders");
       // .to("rest:http4:gg55.irobotbox.com/Api/API_Irobotbox_Orders.asmx??bridgeEndpoint=true&op=GetOrders");


        // 测试连接http 转发

        rest("/test")
                .get("/all")
                .produces("application/json")
                .to("http://www.baidu.com?bridgeEndpoint=true");


    }
}
