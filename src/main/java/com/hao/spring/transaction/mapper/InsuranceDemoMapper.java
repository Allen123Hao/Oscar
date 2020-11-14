package com.hao.spring.transaction.mapper;

import com.hao.spring.transaction.service.InsuranceDemo;
import org.apache.ibatis.annotations.Insert;

/**
 * <code>InsuranceDemoMapper</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-11-06
 * @version: 1.0
 */
public interface InsuranceDemoMapper {

    @Insert("insert into insurance_demo (name,product_code) values (#{name},#{productCode})")
    int insert(InsuranceDemo insuranceDemo);
}
