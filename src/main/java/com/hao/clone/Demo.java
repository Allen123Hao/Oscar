package com.hao.clone;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <code>Demo</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
public class Demo {

    public static double sumList(List<? extends Number> list) {
        return list.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static List covertUpper(List<String> list){
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static Employee maxEmployee(){
        Employee employee = new Employee(0,"Hao");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Allen"));
        employees.add(new Employee(2,"Jack"));

        return employees.stream().max(Comparator.comparing(Employee::getId)).orElse(employee);
    }

    public static void main(String[] args) {
        System.out.println(maxEmployee());
    }
}
