package com.oscar.service;

import com.oscar.entity.BrandRank;

import java.util.List;

/**
 * <code>IExcelOperateService</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/7
 * @version: 1.0
 */
public interface IExcelOperateService {
    List<BrandRank.Brand> initBrands();
}
