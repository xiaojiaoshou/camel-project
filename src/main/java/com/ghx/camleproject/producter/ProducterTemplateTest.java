package com.ghx.camleproject.producter;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: ${name}
 * @description:
 * @type: JAVA
 * @since: 2020/8/5 16:50
 * @author: guohuixiang
 */
@Service
public class ProducterTemplateTest {

    @Autowired
    ProducerTemplate producerTemplate;

    public Object send(Object param) {
        //ExchangePattern.InOut 表示等待结果返回
        Object result = producerTemplate.sendBody("direct:dd", ExchangePattern.InOut, param);
        System.out.println(result);
        return result;

    }
}
