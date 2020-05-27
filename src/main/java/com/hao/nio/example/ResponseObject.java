package com.hao.nio.example;

import java.io.Serializable;

/**
 * <code>ResponseObject</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-19
 * @version: 1.0
 */
public class ResponseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String value;

    private byte[] bytes;

    public ResponseObject(String name, String value) {
        this.name = name;
        this.value = value;
        this.bytes = new byte[1024];
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", bytes=" + bytes.length +
                '}';
    }
}
