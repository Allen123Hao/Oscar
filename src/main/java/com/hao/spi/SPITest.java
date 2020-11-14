package com.hao.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * <code>SPITest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-08-18
 * @version: 1.0
 */
public class SPITest {

    public static void main(String[] args) {
        Iterator<SPIService> providers =  Service.providers(SPIService.class);
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

        while(providers.hasNext()){
            SPIService spiService = providers.next();
            spiService.execute();
        }

        System.out.println("*****************");

        Iterator<SPIService> iterator = load.iterator();
        while(iterator.hasNext()){
            SPIService spiService = iterator.next();
            spiService.execute();
        }
    }
}
