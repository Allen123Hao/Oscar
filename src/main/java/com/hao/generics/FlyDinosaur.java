package com.hao.generics;

import lombok.Data;

/**
 * <code>FlyDinosaur</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
@Data
public class FlyDinosaur extends Dinosaur implements Fly<FlyDinosaur>,Cloneable{

    private int hight;

    public FlyDinosaur(String name){
        super(name);
    }

    public FlyDinosaur(String name,int hight){
        super(name);
        this.hight = hight;
    }

    @Override
    public boolean isHigher(FlyDinosaur o) {
        return this.hight > o.hight;
    }

    @Override
    public void run() {
        System.out.println("I am FlyDinosaur,i also can run");
    }

    @Override
    public FlyDinosaur clone() throws CloneNotSupportedException{
        return (FlyDinosaur) super.clone();
    }
}
