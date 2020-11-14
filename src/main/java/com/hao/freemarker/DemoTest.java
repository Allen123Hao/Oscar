package com.hao.freemarker;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.*;
import lombok.Data;
import org.junit.Test;

import java.io.ObjectOutput;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <code>DemoTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-20
 * @version: 1.0
 */
public class DemoTest {

    @Test
    public void test1() throws Exception{
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        JSONObject create = new JSONObject();
        create.put("insuCityCode","333");
        JSONObject paramData = new JSONObject();
        paramData.put("create",create);
        JSONObject entity = new JSONObject();
        entity.put("paramData",paramData);
        JSONObject data = new JSONObject();
        data.put("entity",entity);
        System.out.println(data);
        String tplValue = "${entity.paramData.create.insuCityCode}";
        StringWriter stringWriter =new StringWriter();

        Template template = new Template("2", tplValue, configuration);
        template.process(data, stringWriter);
        System.out.println(stringWriter.toString());
    }

    @Test
    public void test2() throws Exception{
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        Map<String,Object> data = new HashMap();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","allen");
        data.put("entity",jsonObject);
        String tplValue = "name:${entity.name}";
        StringWriter stringWriter =new StringWriter();
        Template template = new Template("2", tplValue, configuration);
        template.process(data, stringWriter);
        System.out.println(stringWriter.toString());
    }
}
