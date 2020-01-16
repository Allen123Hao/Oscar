package com.hao.clone;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <code>Body</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
@Getter
@Setter
public class Body implements Cloneable{

    private String name;

    private Head head;

    @Override
    public Body clone() throws CloneNotSupportedException{
        Body body = (Body) super.clone();
        body.head = head.clone();
        return body;
    }
}
