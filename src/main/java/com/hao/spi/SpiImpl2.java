package com.hao.spi;

/**
 * <code>SpiImpl2</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-08-18
 * @version: 1.0
 */
public class SpiImpl2 implements SPIService {
    @Override
    public void execute() {
        System.out.println("SpiImpl2.execute()");
    }
}
