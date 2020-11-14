package com.hao.corejava;

/**
 * <code>Demo4</code>
 *
 * @description: 重写的调用
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-09-18
 * @version: 1.0
 */
public class Demo4 {

    static class Grandpa{
        protected void print(){
            System.out.println("Grandpa");
        }
    }

    static class Father extends Grandpa{
        @Override
        protected void print(){
            System.out.println("Father");
        }
    }

    static class Son extends Father{

    }

    public static void main(String[] args) {
        Son son = new Son();
        son.print();
    }
}
