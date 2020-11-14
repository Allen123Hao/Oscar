package com.hao.spring.schema;

import com.hao.spring.core.ContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <code>TestService</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-22
 * @version: 1.0
 */
@Service
public class TestService {

    @Autowired
    private ISCFService proxyService;

    public void testInvoke(){
        System.out.println("测试proxyService服务");
//        ProxyService proxyService = (ProxyService) ContextUtils.getBean("proxyService");
        proxyService.invoke();
//        String desc = proxyService.getDesc();
//        System.out.println("desc"+desc);
    }
}
