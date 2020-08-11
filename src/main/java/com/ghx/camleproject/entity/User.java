package com.ghx.camleproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @name: ${name}
 * @description:
 * @type: JAVA
 * @since: 2020/8/5 14:47
 * @author: guohuixiang
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
}
