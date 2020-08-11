package com.ghx.camleproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @name: ${name}
 * @description:
 * @type: JAVA
 * @since: 2020/8/5 11:52
 * @author: guohuixiang
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private long id;
    private String name;
    private String subject;

}
