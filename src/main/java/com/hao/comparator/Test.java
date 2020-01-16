package com.hao.comparator;

import java.util.*;

/**
 * <code>Test</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/1/19
 * @version: 1.0
 */
public class Test {
    private static List<Car> initCars(){
        String[] names = {"奔驰","奥迪","宝马","劳斯莱斯","宾利","保时捷"};
        List<Car> cars = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Car car = new Car();
            car.setId(i);
            car.setName(names[i]);
            Random random = new Random();
            car.setPrice(random.nextInt(100000));
            cars.add(car);
        }
        for(Car car : cars){
            System.out.println(car.toString());
        }
        return cars;
    }
    public static void main(String[] args) {
        List<Car> cars = initCars();
        Collections.sort(cars,new SortCars());
        System.out.println("排序后：");
        for(Car car : cars){
            System.out.println(car);
        }
    }
}

class SortCars implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        if(o1 == null || o2 == null){
            return 0;
        }
        return (int) (o1.getPrice()-o2.getPrice());
    }
}


