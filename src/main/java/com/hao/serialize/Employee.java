package com.hao.serialize;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * <code>Employee</code>
 *
 * @description: 明确serialVersionUID后再序列化，继承的类添加属性，反序列化会异常，父类没事
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-08
 * @version: 1.0
 */
@Data
public class Employee extends Student {

    private String company;

    private String company1;

    private Map<String,String> map;

}
