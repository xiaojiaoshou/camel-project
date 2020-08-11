package com.ghx.camleproject.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @name: ${name}
 * @description:
 * @type: JAVA
 * @since: 2020/8/11 20:34
 * @author: guohuixiang
 */

@Data
public class OrderDTO implements Serializable {

    private Integer CustomerID;

    private String UserName;

    private String StartTime;

    private String EndTime;

}
