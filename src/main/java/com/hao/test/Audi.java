package com.hao.test;

/**
 * <code>Audi</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/21
 * @version: 1.0
 */
public class Audi extends Car{

    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Car audi = new Audi();
        if(audi instanceof Car){
            System.out.println("audi instanceof Car");
        }
        if(audi instanceof BMW){
            System.out.println("audi instanceof BMW");
        }
        if(audi instanceof Audi){
            System.out.println("audi instanceof Audi");
        }

    }
}
