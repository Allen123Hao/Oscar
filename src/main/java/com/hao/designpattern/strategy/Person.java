package com.hao.designpattern.strategy;

/**
 * <code>Person</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/1
 * @version: 1.0
 */
public class Person {
    private TravelStrategy travel;
    public Person(TravelStrategy travelStrategy){
        this.travel = travelStrategy;
    }
    public void travel(){
        travel.travel();
    }

    public static void main(String[] args){
        Person p1 = new Person(new AirplaneStrategy());
        Person p2 = new Person(new BicycleStrategy());
        p1.travel();
        p2.travel();
    }
}
