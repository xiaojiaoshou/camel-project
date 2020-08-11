package com.ghx.camleproject.saihe;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SaiHeApiRouteBuilder extends SpringRouteBuilder {


    @Override
    public void configure() throws Exception {


        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.off);
        //.producerComponent("http4");


        rest("/servlet")
                .post("/rest")
                .to("direct:rest");
                //.to("mock:result");


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
