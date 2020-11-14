package com.hao.concurrence.countdownlatch.checkhealth;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * <code>ApplicationStartupUtil</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/25
 * @version: 1.0
 */
public class ApplicationStartupUtil {

    //List of service checkers
    private static List<BaseHealthChecker> _services;

    //This latch will be used to wait on
    private static CountDownLatch _latch;

    private ApplicationStartupUtil(){
    }

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance(){
        return INSTANCE;
    }

    public static boolean checkExternalServices() throws Exception{
        //Initialize the latch with number of service checkers
        _latch = new CountDownLatch(3);
        //All add checker in lists
        _services = new ArrayList<BaseHealthChecker>();
        _services.add(new NetworkHealthChecker(_latch));
        _services.add(new DatabaseHealthChecker(_latch));
        _services.add(new CacheHealthChecker(_latch));

        //Start service checkers using executor framework
        Executor executor = Executors.newFixedThreadPool(_services.size());
        for(final BaseHealthChecker checker : _services){
            executor.execute(checker);
        }
        System.out.println("==========");
        //Now wait till all services are checked
        _latch.await();
        System.out.println("**********");
        //Services are file and now proceed startup
        for(final BaseHealthChecker checker : _services){
            if(!checker.isServiceUp()){
                return false;
            }
        }
        return true;

    }

}
