package com.hao.spring.transaction;

import com.hao.spring.transaction.service.InsuranceDemoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <code>TransactionConfig</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-11-06
 * @version: 1.0
 */
public class TransactionTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/hao/spring/transaction/spring-transaction.xml");
        InsuranceDemoService demoService = (InsuranceDemoService) context.getBean("insuranceDemoService");
        demoService.insertData();
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/hao/spring/transaction/spring-transaction.xml");
        InsuranceDemoService demoService = (InsuranceDemoService) context.getBean("insuranceDemoService");
        demoService.asynInsertData();
    }
}
