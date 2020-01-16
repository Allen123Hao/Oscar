package com.hao.clone;

/**
 * <code>App</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
public class App {

    public static void main(String[] args) throws Exception{
        Body body1 = new Body();
        body1.setHead(new Head());
        Body body2 = body1.clone();

        System.out.println(body1);
        System.out.println(body2);
        System.out.println(body1 == body2);
        System.out.println(body1.getHead() == body2.getHead());
    }
}
