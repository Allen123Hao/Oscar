package com.hao.io;

import java.io.*;

/**
 * <code>Demo2</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/14
 * @version: 1.0
 */
public class Demo2 {
    public void fun1(){
        File file = new File("E:\\test\\student.txt");
        try {
            InputStreamReader insReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufReader = new BufferedReader(insReader);
            String line;
            while((line = bufReader.readLine())!= null){
                System.out.println(line);
            }
            bufReader.read();
            bufReader.close();
            insReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fun2(){
        File file = new File("E:\\test\\student.txt");
        try {
            InputStreamReader insReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufReader = new BufferedReader(insReader);
            int i;
            while(true){
                char[] chars = new char[10];
                if((i = bufReader.read(chars)) != -1){
                    System.out.print(chars);
                }else{
                    break;
                }
            }
            bufReader.read();
            bufReader.close();
            insReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fun3(){
        String str = "abcdefg\n\rhijklmn";
        System.out.println(str);
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.fun3();
    }
}
