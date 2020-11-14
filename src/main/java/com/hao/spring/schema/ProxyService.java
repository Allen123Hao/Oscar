package com.hao.spring.schema;

import org.springframework.stereotype.Service;

/**
 * <code>ProxyService</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-21
 * @version: 1.0
 */
public class ProxyService implements ISCFService {
    private String url;
    private Class interfaceName;
    private String serVersion;
    private String desc;

    public ProxyService(String url,Class interfaceName,String serVersion,String desc){
        this.url = url;
        this.interfaceName = interfaceName;
        this.serVersion = serVersion;
        this.desc = desc;
    }

    public void invoke(){
        System.out.println("url:"+url);
        System.out.println("interfaceName:"+interfaceName.getName());
        System.out.println("serVersion:"+serVersion);
        System.out.println("desc:"+desc);
    }
}
