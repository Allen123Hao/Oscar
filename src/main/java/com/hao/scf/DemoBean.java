package com.hao.scf;

/**
 * <code>DemoBean</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-04-24
 * @version: 1.0
 */
public class DemoBean {

    public void say(String str){
        System.out.println("Hello:"+str);
    }

    public DemoBean getInstance(DemoBean demoBean){
        return demoBean;
    }

}
