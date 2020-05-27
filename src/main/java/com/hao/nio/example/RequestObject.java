package com.hao.nio.example;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;

/**
 * <code>RequestObject</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-19
 * @version: 1.0
 */
@Getter
@Setter
public class RequestObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String value;

    private byte[] bytes;

    public RequestObject(String name, String value) {
        this.name = name;
        this.value = value;
        this.bytes = new byte[1024];
    }

    @Override
    public String toString() {
        return "RequestObject{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", bytes=" + bytes.length +
                '}';
    }
}
