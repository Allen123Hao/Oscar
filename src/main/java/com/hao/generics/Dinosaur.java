package com.hao.generics;

import lombok.Data;

import java.util.Collection;

/**
 * <code>Dinosaur</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
@Data
public abstract class Dinosaur implements Animal{

    private String name;

    public Dinosaur(String name) {
        this.name = name;
    }

    @Override
    public abstract void run();

}
