package com.hao.jvm.unsafe;

import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;


/**
 * <code>UnSafeTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-18
 * @version: 1.0
 */
public class UnSafeTest{

    public UnSafeTest(){

    }

    private volatile int state;

    private volatile int head;

    private volatile int tail;

    //java.lang.SecurityException: Unsafe
//    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final Unsafe unsafe;
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;

    static {
        System.out.println("static...");

        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        } catch (IllegalAccessException e) {
            throw new Error(e);
        }

        try {
            stateOffset = unsafe.objectFieldOffset
                    (UnSafeTest.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset
                    (UnSafeTest.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                    (UnSafeTest.class.getDeclaredField("tail"));
        } catch (Exception e) {
            throw new Error(e);
        }
        System.out.println("stateOffset："+stateOffset);
        System.out.println("headOffset："+headOffset);
        System.out.println("tailOffset："+tailOffset);
    }

    public static void printCallerClass(){
        Class cc = Reflection.getCallerClass();
        ClassLoader classLoader = cc.getClassLoader();
        String callerClassName = cc.getName();
        if(classLoader != null){
            System.out.println("classLoader:"+classLoader.toString());
        }else{
            System.out.println("classLoader: null");
        }
        System.out.println("callerClassName:"+callerClassName);
    }

    public static void printCaller(){
        //获取调用者的类名 、 方法
        java.lang.StackTraceElement[] classArray= new Exception().getStackTrace() ;
        for(int i=0;i<classArray.length;i++){
            String classname = classArray[i].getClassName();
            String methodname = classArray[i].getMethodName() ;
            System.out.println("调用数据源的类名：【"+classname+"】，方法名：【"+methodname+"】");
        }
    }

    private void changeField(){
        System.out.println(state);
        if(unsafe.compareAndSwapLong(this,stateOffset,1,2)){
            System.out.println("state from 1 to 2");
        }
        System.out.println(state);
    }

    public static void main(String[] args) {
//        printCaller();
        UnSafeTest unSafeTest = new UnSafeTest();
        unSafeTest.state = 1;
        unSafeTest.changeField();
    }
}
