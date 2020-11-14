package com.hao.spring.scanpackage.example1.mapper;

import com.hao.spring.scanpackage.example1.MyMapper;

/**
 * <code>UserMapper</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-31
 * @version: 1.0
 */

/** 接口，将会被扫描，bean name = userMapper **/
@MyMapper
public interface UserMapper {
    void insert();
}
