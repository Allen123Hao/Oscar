package com.hao.spring.scanpackage.example1.mapper;

/**
 * <code>OrderMapper</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-31
 * @version: 1.0
 */

import com.hao.spring.scanpackage.example1.MyMapper;

/** 接口，将会被扫描，bean name = orderMapperProxy **/
@MyMapper("orderMapperProxy")
public interface OrderMapper {
    void update();
}
