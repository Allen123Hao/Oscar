package com.hao.spring.schema;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.SmartFactoryBean;

/**
 * <code>SCFServiceBean</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-21
 * @version: 1.0
 */
public class SCFServiceBean implements FactoryBean {

    private String url;
    private Class interfaceName;
    private String serVersion;
    private String desc;

    public SCFServiceBean() {
    }

    public Object getObject() throws Exception {
        return new ProxyService(url,interfaceName,serVersion,desc);
    }

    public Class getObjectType() {
        return this.interfaceName;
    }

    public boolean isSingleton() {
        return true;
    }

    public String getUrl() {
        return this.url;
    }

    public SCFServiceBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public Class getInterfaceName() {
        return this.interfaceName;
    }

    public SCFServiceBean setInterfaceName(Class interfaceName) {
        this.interfaceName = interfaceName;
        return this;
    }

    public String getSerVersion() {
        return this.serVersion;
    }

    public void setSerVersion(String serVersion) {
        this.serVersion = serVersion;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

//    @Override
//    public boolean isPrototype() {
//        return false;
//    }
//
//    @Override
//    public boolean isEagerInit() {
//        return true;
//    }
}
