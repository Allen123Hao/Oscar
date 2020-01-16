package com.hao.comparator;

/**
 * <code>ApplicationConfig</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/1/19
 * @version: 1.0
 */
public class Car{
    private int id;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
    @Override
    public int compareTo(ApplicationConfig o) {
        if(o == null || this.price == o.price){
            return 0;
        }
        if(this.price > o.price){
            return 1;
        }
        if(this.price < o.price){
            return -1;
        }
        return 0;
    }
    **/
}
