package com.hao.spring.circledependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <code>B</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-20
 * @version: 1.0
 */
//@Component
public class B {
//    @Autowired
    private A a;

    public void setA(A a){
        this.a = a;
    }

    public B(){
        System.out.println("B Constructor");
    }

    public void print(){
        System.out.println("this is B method");
    }

    public void call(){
        a.print();
    }
}
