package com.hao.serialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * <code>SerializeDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-08
 * @version: 1.0
 */
public class SerializeDemo {

    public static void main(String[] args) {
        Employee student = new Employee();
        student.setId(2);
        student.setName("Allen");
        student.setAddress("北京");
        student.setAge(30);
        student.setBirthday("1986");
        student.setCompany("58同城");
        Map<String,String> map = new HashMap<>();
        map.put("allen","hao");
        student.setMap(map);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("/tmp/student.serial");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(student);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(fos != null){
                    fos.close();
                }
                if(oos != null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
