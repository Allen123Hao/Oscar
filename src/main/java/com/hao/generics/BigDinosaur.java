package com.hao.generics;

import lombok.Data;

/**
 * <code>BigDinosaur</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
@Data
public class BigDinosaur extends Dinosaur {

    public BigDinosaur(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("I am BigDinosaur,i can run.");
    }

}
