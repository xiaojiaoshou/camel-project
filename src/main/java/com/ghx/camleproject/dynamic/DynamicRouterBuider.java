package com.ghx.camleproject.dynamic;

import com.ghx.camleproject.utils.XmlLoadUtils;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestOperationParamDefinition;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @name: ${name}
 * @description:
 * @type: JAVA
 * @since: 2020/8/11 18:37
 * @author: guohuixiang
 */
@Component
public class DynamicRouterBuider extends SpringRouteBuilder {


    @Override
    public void configure() throws Exception {

        Map<String, String> map = XmlLoadUtils.parseXMl();

        String uri = map.get("uri");

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json);

        //  bean方式调用方法
        rest("/servert")
                .post(uri)
                .to("direct:newXml");

        from("direct:newXml")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Message in = exchange.getIn();
                        in.setHeader("Content-Type", "text/xml");
                        in.setHeader(Exchange.HTTP_METHOD, "POST");
                        String body = in.getBody(String.class);
                        System.out.println("========" + body);
                        String params = XmlLoadUtils.getParams(body);
                        exchange.getIn().setBody(params);
                    }
                })
                .to("http://gg55.irobotbox.com/Api/API_Irobotbox_Orders.asmx?op=GetOrders&bridgeEndpoint=true");

    }


}
