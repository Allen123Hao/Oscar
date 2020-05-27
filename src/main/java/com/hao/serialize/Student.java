package com.hao.serialize;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <code>Student</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-08
 * @version: 1.0
 */
@Data
@ToString
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String address;

    private transient int age;

    private transient String birthday;

    private String sex;
}
