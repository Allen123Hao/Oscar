package com.hao.spring.env;

import org.junit.Test;
import org.springframework.core.env.*;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <code>PropertySourceTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-09-14
 * @version: 1.0
 */
public class PropertySourceTest {

    @Test
    public void test1(){
        Map<String, Object> map = new HashMap<>();
        map.put("encoding", "gbk");
        PropertySource ps1 = new MapPropertySource("map",map);
        System.out.println(ps1.getName());
        System.out.println(ps1.getProperty("encoding"));
        PropertySource ps2 = null;
        try {
            ps2 = new ResourcePropertySource("resource","classpath:system.property");
            ps2.getName();
            System.out.println(ps2.getProperty("FS_HDFS_IMPL"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CompositePropertySource cps = new CompositePropertySource("composite");
        cps.addPropertySource(ps1);
        cps.addPropertySource(ps2);
        System.out.println(cps.getProperty("socket2_ip"));

        MutablePropertySources mps = new MutablePropertySources();
        mps.addFirst(ps1);
        mps.addLast(ps2);
        System.out.println(mps.get("resource").getProperty("FS_HDFS_IMPL"));

    }

    @Test
    public void test2(){
        Map<String, Object> map = new HashMap<>();
        map.put("encoding", "gbk");
        PropertySource ps1 = new MapPropertySource("map",map);
        PropertySource ps2 = null;
        try {
            ps2 = new ResourcePropertySource("resource","classpath:system.property");
            ps2.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MutablePropertySources mps = new MutablePropertySources();
        mps.addFirst(ps1);
        mps.addLast(ps2);

        PropertyResolver pr = new PropertySourcesPropertyResolver(mps);
        System.out.println(pr.containsProperty("encoding"));


    }
}
