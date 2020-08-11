package com.ghx.camleproject.controller;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class SaiHeApiRouteController  {

    @Autowired
    ProducerTemplate producerTemplate;

    private String parms = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "  <soap:Body>\n" +
            "    <GetOrders xmlns=\"http://tempuri.org/\">\n" +
            "      <orderRequest>\n" +
            "    <CustomerID>1837</CustomerID>\n" +
            "    <UserName>data009</UserName>\n" +
            "    <Password>data009</Password>\n" +
            "        <StartTime>2019-07-01</StartTime>\n" +
            "        <EndTime>2019-08-01</EndTime>\n" +
            "      </orderRequest>\n" +
            "    </GetOrders>\n" +
            "  </soap:Body>\n" +
            "</soap:Envelope>";

    @RequestMapping("/test")
    public Object getOrders() {

        Object result = producerTemplate.sendBody("direct:meelermeeler", ExchangePattern.InOut, parms);
        System.out.println("返回结果：" + result);

        return result;

    }




}
