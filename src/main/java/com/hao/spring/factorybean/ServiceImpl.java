package com.hao.spring.factorybean;

/**
 * <code>ServiceImpl</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2019-10-23
 * @version: 1.0
 */
public class ServiceImpl implements IService {

    @Override
    public MyService getMyService() {
        return new MyService("Allen");
    }
}
