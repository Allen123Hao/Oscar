package com.hao.spring.initbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <code>Employee</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/30
 * @version: 1.0
 */
public class Employee implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,
        InitializingBean,DisposableBean {

    private String id;// 员工编号
    private String name;// 员工姓名
    private String sex;// 员工性别
    private String age;// 员工年龄
    private String nativePlace;// 员工籍贯
    private String department;// 员工部门
    private String beanName;// bean的名称

    private Employer employer;

    public Employee(){
        System.out.println("调用Employee的无参构造方法");
    }

    public Employee(String name){
        System.out.println("调用Employee的有参构造方法");
        System.out.println("name:"+name);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware的setBeanName方法");
        System.out.println("setBeanName,name:"+name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware的setBeanFactory方法");
        System.out.println("setBeanFactory,beanFactory:"+beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用ApplicationContextAware的setApplicationContext方法");
        System.out.println("setApplicationContext,applicationContext:"+applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean的afterPropertiesSet方法");
    }


//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("调用BeanPostProcessor的postProcessBeforeInitialization方法");
//        System.out.println("postProcessBeforeInitialization,bean:"+bean+",beanName:"+beanName);
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("调用BeanPostProcessor的postProcessAfterInitialization方法");
//        System.out.println("postProcessAfterInitialization,bean:"+bean+",beanName:"+beanName);
//        return bean;
//    }

    public void init(){
        System.out.println("调用init-method的init方法");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean的destroy方法");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBeanName() {
        return beanName;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void test(){
        System.out.println("执行employee的test方法");
        employer.test();
    }
}
