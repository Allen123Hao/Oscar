package com.hao.spring.transaction.service;

import com.hao.spring.transaction.mapper.InsuranceDemoMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <code>InsuranceDemoService</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-11-06
 * @version: 1.0
 */
@Service
public class InsuranceDemoService {

    @Autowired
    private InsuranceDemoMapper insuranceDemoMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertData(){
        InsuranceDemo demo = buildData("111");
        int result = insuranceDemoMapper.insert(demo);
        System.out.println("result:"+result);
        try {
//        insertData1();
            ((InsuranceDemoService)AopContext.currentProxy()).insertData1();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void insertData1(){
        InsuranceDemo demo = buildData("222");
        insuranceDemoMapper.insert(demo);
        int i = 10/0;
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void asynInsertData(){
        InsuranceDemo demo = buildData("33");
        insuranceDemoMapper.insert(demo);
        new Thread(()->{
//            asynInsertData1();
            ((InsuranceDemoService)AopContext.currentProxy()).asynInsertData1();
        }).start();
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void asynInsertData1(){
        InsuranceDemo demo1 = buildData("331");
        insuranceDemoMapper.insert(demo1);
        throw new RuntimeException();
    }

    private InsuranceDemo buildData(String productCode){
        InsuranceDemo insuranceDemo = new InsuranceDemo();
        insuranceDemo.setName("测试1");
        insuranceDemo.setProductCode(productCode);
        return insuranceDemo;
    }
}
