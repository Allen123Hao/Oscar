package com.oscar.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <code>DemoService</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/10/31
 * @version: 1.0
 */
@Service
public class DemoService {
    public void printPage1(){
        System.out.println("go into Page1.");
    }
    @PostConstruct
    public void initFun(){
        System.out.println("===This is initFun===");
    }
    @PreDestroy
    public void destroyFun(){
        System.out.println("===This is destroyFun===");
    }
}
