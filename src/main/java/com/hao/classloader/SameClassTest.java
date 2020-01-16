package com.hao.classloader;

import org.apache.commons.lang.StringUtils;

/**
 * <code>SameClassTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/25
 * @version: 1.0
 */
public class SameClassTest {
    public static void main(String[] args) {
        boolean result = StringUtils.isEmpty("");
        boolean result1 = org.apache.commons.lang.StringUtils.isEmpty("");
        System.out.println(result);
    }
}
