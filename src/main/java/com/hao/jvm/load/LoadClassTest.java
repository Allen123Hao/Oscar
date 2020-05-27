package com.hao.jvm.load;

import java.util.Scanner;

/**
 * <code>LoadClassTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-12
 * @version: 1.0
 */
public class LoadClassTest {

    public static void main(String[] args) {
        System.out.println("主线程");
        ClassInfo classInfo = new ClassInfo();
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next());
        System.out.println(scanner.next());
    }
}
