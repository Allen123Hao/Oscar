package com.hao.spring.scanpackage.example1.mapper;

/**
 * <code>StudentMapper</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-31
 * @version: 1.0
 */

import com.hao.spring.scanpackage.example1.MyMapper;

/** 顶层具体类，使用@MyMapper标记 **/
@MyMapper
public class StudentMapper {

    public void query(){
        System.out.println("StudentMapper.query");
    }
}
