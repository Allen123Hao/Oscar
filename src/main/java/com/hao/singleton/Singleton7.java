package com.hao.singleton;

/**
 * <code>Singleton7</code>
 *
 * @description: 双重校验锁
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/9/21
 * @version: 1.0
 */
public class Singleton7 {
    public volatile static Singleton7 instance;

    private Singleton7(){

    }

    public static Singleton7 getInstance(){
        if(instance == null){
            synchronized (Singleton7.class){
                if(instance == null){
                    instance = new Singleton7();
                }
            }
        }
        return instance;
    }
}
