package com.hao.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * <code>SCFNSHandler</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-21
 * @version: 1.0
 */
public class SCFNSHandler  extends NamespaceHandlerSupport {

    @Override
    public void init() {
        this.registerBeanDefinitionParser("service", new SCFBeanDefParser());
    }
}
