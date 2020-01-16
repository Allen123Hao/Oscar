package com.hao.rpc;

/**
 * <code>PersonClient</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/16
 * @version: 1.0
 */
public class PersonClient {
    public static void main(String[] args) {
        try {
            Person person = new Person_Stub();
            int age = person.getAge();
            String name = person.getName();
            System.out.println(name +  " is "  + age +  " years old" );
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
