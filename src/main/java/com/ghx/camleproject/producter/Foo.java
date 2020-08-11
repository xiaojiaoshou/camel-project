package com.ghx.camleproject.producter;

import com.ghx.camleproject.service.MyListener;
import org.apache.camel.EndpointInject;
import org.springframework.stereotype.Component;

/**
 * @name: ${name}
 * @description:
 * @type: JAVA
 * @since: 2020/8/5 17:11
 * @author: guohuixiang
 */
@Component
public class Foo {

    @EndpointInject(uri = "direct:dd")
    protected MyListener producer;

    public Object doSomething() {
        System.out.println("方法被调用....");
        return producer.sayHello("<hello>world!</hello>");
    }

}
