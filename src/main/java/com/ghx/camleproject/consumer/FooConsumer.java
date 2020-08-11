package com.ghx.camleproject.consumer;

import org.apache.camel.Consume;
import org.springframework.stereotype.Component;

/**
 * @name: ${name}
 * @description:
 * @type: JAVA
 * @since: 2020/8/5 17:30
 * @author: guohuixiang
 */
@Component
public class FooConsumer {

    @Consume(uri = "direct:doSomething")
    public String doSomething() {
        System.out.println("方法被调用....");
        return "FooConsumer.....";
    }
}
