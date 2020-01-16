package com.hao.clone;

/**
 * <code>Head</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
public class Head implements Cloneable{

    @Override
    public Head clone() throws CloneNotSupportedException{
        return (Head) super.clone();
    }
}
