package com.oscar.bean.page;

import java.util.List;

/**
 * <code>BasePage</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/10/27
 * @version: 1.0
 */
public class BasePage<T> {
    private Page p;
    private List<T> list;

    public Page getP() {
        return p;
    }

    public void setP(Page p) {
        this.p = p;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
