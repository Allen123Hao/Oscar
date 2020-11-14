package com.hao.spi;

/**
 * <code>SpiImpl1</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-08-18
 * @version: 1.0
 */
public class SpiImpl1 implements SPIService {
    @Override
    public void execute() {
        System.out.println("SpiImpl1.execute()");
    }
}
