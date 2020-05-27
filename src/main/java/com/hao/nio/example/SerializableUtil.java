package com.hao.nio.example;

import java.io.*;

/**
 * <code>SerializableUtil</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-05-19
 * @version: 1.0
 */
public class SerializableUtil {

    public static byte[] toBytes(Object obj){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(),e);
        } finally {
            try {
                oos.close();
                baos.close();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(),e);
            }
        }
    }

    public static Object toObject(byte[] bytes){
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bais);
            Object obj = ois.readObject();
            return obj;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(),e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e.getMessage(),e);
        }finally {
            try {
                ois.close();
                bais.close();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(),e);
            }
        }
    }
}
