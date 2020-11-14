package com.hao.test;

/**
 * <code>BMW</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/21
 * @version: 1.0
 */
public class BMW extends Car {

    public BMW(){
        System.out.println("BMW的无参构造方法");
    }

//    public BMW(float price){
//        super(1,"宝马");
//        this.price = price;
//    }

    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void func1(){
        func2();
    }

    public static void main(String[] args) {
//        BMW bmw = new BMW(1.0f);
//        System.out.println(bmw.getName());
        BMW bmw = new BMW();
    }
}
