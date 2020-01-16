package com.oscar.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * <code>SpringQtz1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/10/31
 * @version: 1.0
 */
public class SpringQtz1 extends QuartzJobBean {
    private static int count = 0;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println();
        long ms = System.currentTimeMillis();
        System.out.println("\t\t" + new Date(ms));
        System.out.println(ms);
        System.out.println("("+ count++ +")");
        String s = (String) jobExecutionContext.getMergedJobDataMap().get("service");
        System.out.println(s);
        System.out.println();
    }
}
