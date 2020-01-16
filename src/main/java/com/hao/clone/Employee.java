package com.hao.clone;

import lombok.Data;

/**
 * <code>Employee</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
@Data
public class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
