package com.hao.test.ut;
public class MockClass {
    public static int ADD_NUM = 2;
    public int test = 10;
    public int publicMethod(int num) {
        System.out.println("有反参公有方法执行了");
        return num + ADD_NUM;
    }
    public void publicMethodNoReturn(int num) {
        System.out.println("无反参公有方法执行了");
    }

    public final int finalMethod(int num){
        System.out.println("final方法执行了");
        return num + ADD_NUM;
    }
    private int privateMethod(int num) {
        System.out.println("私有方法执行了");
        return num + ADD_NUM;
    }
    public int callPrivateMethod(int num){
        return privateMethod(num);
    }
    public static int staticMethod(int num){
        System.out.println("静态方法执行了");
        return ADD_NUM + num;
    }
    public MockClass(int test) {
        this.test = test;
    }
    public MockClass() {}

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}
