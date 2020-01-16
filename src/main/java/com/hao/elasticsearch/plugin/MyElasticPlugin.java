package com.hao.elasticsearch.plugin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestHandler;

import java.util.Collections;
import java.util.List;

/**
 * <code>MyElasticPlugin</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/8
 * @version: 1.0
 */
public class MyElasticPlugin extends Plugin implements ActionPlugin {
    private final static Logger LOGGER = LogManager.getLogger(MyElasticPlugin.class);
    public MyElasticPlugin() {
        super();
        LOGGER.warn("Create the Basic Plugin and installed it into elasticsearch");
    }

    public List<Class<? extends RestHandler>> getRestHandlers() {
        return Collections.singletonList(MyRestAction.class);
    }
}
