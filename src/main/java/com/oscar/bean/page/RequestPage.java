package com.oscar.bean.page;

/**
 * <code>RequestPage</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/10/27
 * @version: 1.0
 */
public class RequestPage {
    private Integer offset;
    private Integer pageSize;
    private Integer curPage;
    private String[] oderBy;//排序依据
    private String[] order;//排序规则，与orderBy一一对应
    private Object params = new Object();//其他条件

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public String[] getOderBy() {
        return oderBy;
    }

    public void setOderBy(String[] oderBy) {
        this.oderBy = oderBy;
    }

    public String[] getOrder() {
        return order;
    }

    public void setOrder(String[] order) {
        this.order = order;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }
}
