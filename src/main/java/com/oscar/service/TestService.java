package com.oscar.service;

import cn.hutool.json.JSONUtil;
import com.oscar.bean.Student;
import com.oscar.bean.StudentExample;
import com.oscar.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <code>TestService</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/20
 * @version: 1.0
 */
@Service
public class TestService {
    @Autowired
    private StudentMapper studentMapper;

    @Transactional(readOnly = true)
    public void queryStudent(){
        Student student = studentMapper.selectByPrimaryKey(1);
        System.out.println(JSONUtil.toJsonStr(student));
    }

    public void testStudent1(){
        Student student = new Student();
//        student.setId(1);
        student.setName("Hao Xueqiang1");
        student.setScore(100L);
        int result = studentMapper.insert(student);
        System.out.println("id:"+student.getId());
        System.out.println("result:"+result);
    }

    public void testStudent2(){
        Student student = studentMapper.selectByPrimaryKey(1);
        student.setScore(2200000099L);
        int i = studentMapper.updateByPrimaryKeySelective(student);
        System.out.println("result i:"+i);
    }
}
