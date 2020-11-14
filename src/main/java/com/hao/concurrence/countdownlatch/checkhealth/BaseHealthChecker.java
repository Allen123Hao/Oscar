package com.hao.concurrence.countdownlatch.checkhealth;

import java.util.concurrent.CountDownLatch;

/**
 * <code>BaseHealthChecker</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/5/25
 * @version: 1.0
 */
public abstract class BaseHealthChecker implements Runnable{
    private CountDownLatch _latch;
    private String _serviceName;
    private boolean _serviceUp;

    //Get latch object in constructor so that after completing the task, thread can countDown() the latch
    public BaseHealthChecker(String serviceName,CountDownLatch latch){
        super();
        this._serviceName = serviceName;
        this._latch = latch;
        this._serviceUp = false;
    }

    @Override
    public void run() {
        try {
            verifyService();
            _serviceUp = true;
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            _serviceUp = false;
        } finally {
            if(_latch != null){
                System.out.println("finally:"+this.getServiceName()+",_latch:"+_latch);
                _latch.countDown();
            }
        }
    }

    public String getServiceName() {
        return _serviceName;
    }

    public boolean isServiceUp() {
        return _serviceUp;
    }

    //This methos needs to be implemented by all specific service checker
    public abstract void verifyService();

}
