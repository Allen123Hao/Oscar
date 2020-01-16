package com.hao.classloader;

/**
 * <code>ClassLoaderTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/12
 * @version: 1.0
 */
public class ClassLoaderTest {

    private int flag;

    private void func1(){
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        while(classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
        System.out.println(classLoader);
    }

    private void func2(){
//        String rootUrl = "http://localhost:8090/httpweb/";
        String rootUrl = "file:///Users/haoxueqiang/WorkSpace/Oscar/oscar/target/classes/";
        NetWorkClassLoader netWorkClassLoader = new NetWorkClassLoader(rootUrl);
        String className = "com.hao.classloader.NetWorkClassLoader";
        Class clazz = null;
        try {
            clazz = netWorkClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz.getClassLoader());
    }

    public void func3(){
        ClassLoaderLK classLoaderLK = new ClassLoaderLK("");
        ClassLoader loader1 = ClassLoaderLK.class.getClassLoader();
        System.out.println("loader1:"+loader1);
        ClassLoader loader2 = classLoaderLK.getParent();
        System.out.println("loader2:" + loader2);
        ClassLoader loader3 = loader2.getParent();
        System.out.println("loader3:"+loader3);
    }

    public void func4(){
        ClassLoader cls = Thread.currentThread().getContextClassLoader();
        ClassLoaderTest test1 = this;
        if(cls == this.getClass().getClassLoader()){
            System.out.println(this);
            System.out.println("cls1");
        }
        if(cls == ClassLoaderTest.class.getClassLoader()){
            System.out.println("cls2");
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                ClassLoader cls1 = Thread.currentThread().getContextClassLoader();
                if(cls1 == this.getClass().getClassLoader()){
                    System.out.println(this);
                    System.out.println("cls3");
                }
                if(cls1 == ClassLoaderTest.class.getClassLoader()){
                    System.out.println("cls4");
                }
                if(cls == cls1){
                    System.out.println("cls5");
                }
            }
        }).run();
    }



    public static void main(String[] args) {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
//        classLoaderTest.flag = 10;
        classLoaderTest.func2();
    }

}
