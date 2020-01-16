package com.hao.mybatis;

import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <code>MybatisTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@kingsoft.com)
 * @creation: 2019/5/16
 * @version: 1.0
 */
public class MybatisTest {

    public SqlSessionFactory create(){
        String resource = "springtest/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    public void test(){
        SqlSessionFactory sqlSessionFactory = create();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Student> list = sqlSession.selectList("com.hao.mybatis.StudentMapper.query10",10);
        System.out.println(new Gson().toJson(list));
    }

    public static void main(String[] args) {
        MybatisTest test = new MybatisTest();
        test.test();

    }
}
