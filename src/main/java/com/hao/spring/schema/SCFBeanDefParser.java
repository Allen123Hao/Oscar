package com.hao.spring.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * <code>SCFBeanDefParser</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-06-21
 * @version: 1.0
 */
public class SCFBeanDefParser extends AbstractSingleBeanDefinitionParser {

    protected Class<SCFServiceBean> getBeanClass(Element element) {
        return SCFServiceBean.class;
    }

    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String id = element.getAttribute("id");
        if (!StringUtils.hasText(id) || !parserContext.getRegistry().containsBeanDefinition(id)) {
            String url = element.getAttribute("url");
            if (StringUtils.hasText(url)) {
                builder.addPropertyValue("url", url);
            }

            String iface = element.getAttribute("interface");
            if (StringUtils.hasText(iface)) {
                try {
                    Class clazz = Class.forName(iface);
                    builder.addPropertyValue("interfaceName", clazz);
                } catch (ClassNotFoundException var9) {
                    throw new IllegalArgumentException(" interface not found " + iface);
                }
            }

            String serVersion = element.getAttribute("serVersion");
            if (StringUtils.hasText(serVersion)) {
                builder.addPropertyValue("serVersion", serVersion);
            }

            String desc = element.getAttribute("desc");
            if (StringUtils.hasText(desc)) {
                builder.addPropertyValue("desc", desc);
            }

        }
    }
}
