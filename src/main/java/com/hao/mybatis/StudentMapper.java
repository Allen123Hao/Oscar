package com.hao.mybatis;

import java.util.List;

/**
 * <code>StudentMapper</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/17
 * @version: 1.0
 */
public interface StudentMapper {
    List<Student> query10(int line);
}
