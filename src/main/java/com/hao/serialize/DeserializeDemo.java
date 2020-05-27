package com.hao.serialize;

import java.io.*;

/**
 * <code>DeserializeDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-08
 * @version: 1.0
 */
public class DeserializeDemo {

    public static void main(String[] args) {
        Employee student = null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("/tmp/student.serial");
            ois = new ObjectInputStream(fis);
            student = (Employee) ois.readObject();
            System.out.println("id:"+student.getId());
            System.out.println("name:"+student.getName());
            System.out.println("address:"+student.getAddress());
            System.out.println("age:"+student.getAge());
            System.out.println("birthday:"+student.getBirthday());
            System.out.println("company:"+student.getCompany());
            System.out.println("map:"+student.getMap().get("allen"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                if(fis != null){
                    fis.close();
                }
                if(ois != null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
