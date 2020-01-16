package com.hao.lambda;

import java.util.function.Consumer;

/**
 * <code>Demo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/8
 * @version: 1.0
 */
public class Demo1 {
    public void func1(Test test){
        System.out.println(test.print1());
    }

    public void func2(Test1 test1){
        Integer a = 10;
        test1.accept(a);
    }

    public void func3(){
        Test1<String> test1 = t -> System.out.println(t);
        test1.accept("hello");
    }

    public Test2 func4(){
        return t -> {
            t.setId(1);
            t.setAge(20);
            t.setName("Hao");
            System.out.println(t);
        };
    }

    public Test2 func5(){
        return new Test2() {
            @Override
            public void accept(People people) {
                people.setId(2);
                people.setAge(30);
                people.setName("Hao");
                System.out.println(people);
            }
        };
    }

    Consumer<Integer> c = (Integer x) -> {
        System.out.println(x);
    };


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
//        demo1.func1(new Test() {
//            @Override
//            public int print() {
//                return 20;
//            }
//        });
        demo1.func1(() -> 20);
        demo1.func1( () -> {return 30;});
//        demo1.func2(new Test1() {
//            @Override
//            public void accept(Object o) {
//                System.out.println(o);
//            }
//        });
        demo1.func2(x -> System.out.println(x));
        demo1.func3();
        Test2 test22 = demo1.func4();
        test22.accept(new People());
        Test2 test23 = demo1.func5();
        test23.accept(new People());

    }
}

//函数式接口只包含一个抽象方法声明的接口
@FunctionalInterface
interface Test{
    int print1();
//    int print2();

}

@FunctionalInterface
interface Test1<T>{
    void accept(T t);
}

@FunctionalInterface
interface Test2 extends Test1<People>{
}
