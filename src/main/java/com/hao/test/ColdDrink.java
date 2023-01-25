package com.hao.test;

/**
 * <code>ColdDrink</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2023-01-04
 * @version: 1.0
 */
public class ColdDrink extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}

