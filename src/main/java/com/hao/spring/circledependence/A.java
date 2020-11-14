package com.hao.spring.circledependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <code>A</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-20
 * @version: 1.0
 */
//@Component
public class A {
//    @Autowired
    private B b;

    public void setB(B b){
        this.b = b;
    }

    public A(){
        System.out.println("A Constructor");
    }

    public void print(){
        System.out.println("this is A method");
    }

    public void call(){
        b.print();
    }
}
