package com.hao.spring.scanpackage.example1;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <code>MapperFactoryBean</code>
 *
 * @description: 用来生成接口的代理实现
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-10-31
 * @version: 1.0
 */
public class MapperFactoryBean<T> implements FactoryBean<T>, InitializingBean {

    /**
     * 代理的接口
     */
    private Class<T> mapperInterface;

    /**
     * 代理对象
     */
    private T mapperObject;

    public MapperFactoryBean(Class<T> mapperInterface) {
        if(mapperInterface == null || !mapperInterface.isInterface()) {
            throw new IllegalArgumentException(mapperInterface + "must be a interface.");
        }
        this.mapperInterface = mapperInterface;
    }


    @SuppressWarnings("unchecked")
    private T createProxy() {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class<?>[]{mapperInterface},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) {
                        System.out.println(method.getName() + " is called.");
                        // 注意代理方法的返回值不能是基本类型, 否则返回null会发生空指针异常.
                        return null;
                    }
                });
    }

    @Override
    public T getObject() throws Exception {
        if(mapperObject == null) {
            mapperObject = createProxy();
        }
        return mapperObject;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * 此方法会在Spring创建对象后, 并且调用了所有配置文件中配置属性的setter方法后执行
     * 在这里我们检查下参数以及创建接口代理对象
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // 检查参数
        if(mapperInterface == null || !mapperInterface.isInterface()) {
            throw new IllegalArgumentException(mapperInterface + "must be a interface.");
        }
        if(mapperObject == null) {
            mapperObject = createProxy();
        }

    }
}
