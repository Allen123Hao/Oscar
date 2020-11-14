package com.hao.spring.initbean;

/**
 * <code>Employer2</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-09-11
 * @version: 1.0
 */
public class Employer2 {
    private String name;

    private double salary;

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public Employer2(){
        System.out.println("构造方法Employer2()");
    }

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("Employer postProcessBeforeInitialization,bean:"+bean+",beanName:"+beanName);
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("Employer postProcessAfterInitialization,bean:"+bean+",beanName:"+beanName);
//        return bean;
//    }

    public void initTest(){
        System.out.println("执行employer2的initTest方法");
    }


    public void test(){
        System.out.println("执行employer2的test方法");
    }
}
