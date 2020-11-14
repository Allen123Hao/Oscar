package com.hao.spring.scanpackage.example1;

import com.hao.spring.scanpackage.example1.mapper.OrderMapper;
import com.hao.spring.scanpackage.example1.mapper.StudentMapper;
import com.hao.spring.scanpackage.example1.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <code>ScannerTest</code>
 *
 * @description: 实现一个将指定包下的带有@Mapper标记的接口生成代理注册到Spring容器中，命名将与MyBatis-Spring一致。
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-31
 * @version: 1.0
 */
public class ScannerTest {
    @Test
    public void scan() {
        ///com/hao/spring/scanpackage/example1/spring-scan.xml
        String path1 = ScannerTest.class.getResource("/com/hao/spring/scanpackage/example1/spring-scan.xml").getPath();
        System.out.println(path1);
        String path2 = ScannerTest.class.getResource("spring-scan.xml").getPath();
        System.out.println(path2);
        String path3 = ScannerTest.class.getClassLoader().getResource("com/hao/spring/scanpackage/example1/spring-scan.xml").getPath();
        System.out.println(path3);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/com/hao/spring/scanpackage/example1/spring-scan.xml");
        UserMapper userMapper = applicationContext
                .getBean("userMapper", UserMapper.class);
        Assert.assertNotNull(userMapper);
        userMapper.insert();
        OrderMapper orderMapper = applicationContext
                .getBean("orderMapperProxy", OrderMapper.class);
        Assert.assertNotNull(orderMapper);
        orderMapper.update();

//        StudentMapper studentMapper = applicationContext.getBean("studentMapper",StudentMapper.class);
//        Assert.assertNotNull(studentMapper);
//        studentMapper.query();
    }

}
