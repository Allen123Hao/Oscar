package com.oscar.service;

import java.util.Date;

/**
 * <code>SpringQtz2</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/10/31
 * @version: 1.0
 */
public class SpringQtz2 {
    private static int count = 0;
    protected void execute(){
        long ms = System.currentTimeMillis();
        System.out.println("\t\t" + new Date(ms));
        System.out.println("(" + count++ + ")");
    }
}
