package com.hao.generics;

/**
 * <code>Fly</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
public interface Fly<T> {

    boolean isHigher(T t);
}
