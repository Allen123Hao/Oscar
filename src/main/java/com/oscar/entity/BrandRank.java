package com.oscar.entity;

import java.util.List;

/**
 * <code>BrandRank</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/3
 * @version: 1.0
 */
public class BrandRank {
    private String industry;
    private List<Brand> list;

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public List<Brand> getList() {
        return list;
    }

    public void setList(List<Brand> list) {
        this.list = list;
    }

    public static class Brand{
        private String name;
        private String rank;

//        public Brand(String name,String rank){
//            this.name = name;
//            this.rank = rank;
//        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }
    }
}
