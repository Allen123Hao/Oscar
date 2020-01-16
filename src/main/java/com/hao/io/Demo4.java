package com.hao.io;

import java.io.*;

/**
 * <code>Demo4</code>
 *
 * @description: Externalizable和Serializable
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/3/13
 * @version: 1.0
 */
public class Demo4 {

}

class SerialCtl implements Serializable {
    String a;
    transient String b;
    public SerialCtl(String aa, String bb){
        a="Not Transient:"+aa;
        b="Transient:"+bb;
    }
    public String toString(){
        return a+"\n"+b;
    }

    private void writeObject(ObjectOutputStream o)throws IOException {
        o.defaultWriteObject();
        o.writeObject(b);
    }
    private void readObject(ObjectInputStream streamr)throws IOException, ClassNotFoundException{
        streamr.defaultReadObject();
        b=(String)streamr.readObject();
    }

    public static void main(String[] args){
        SerialCtl sc =
                new SerialCtl("Test1","Test2");
        System.out.println("Before:\n"+sc);
        ByteArrayOutputStream buf =
                new ByteArrayOutputStream();
        try{
            ObjectOutputStream out1 = new
                    ObjectOutputStream(buf);

            out1.writeObject(sc);

            ObjectInputStream in1 = new
                    ObjectInputStream(new
                    ByteArrayInputStream(buf.toByteArray()));

            SerialCtl sc2 = (SerialCtl)in1.readObject();
            System.out.println("After:\n"+sc2);

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();

        }
    }
}

class SerialCtl1 implements Serializable{

    String a;
    transient String b;

    public SerialCtl1(String aa, String bb){
        a="Not Transient:"+aa;
        b="Transient:"+bb;
    }
    public String toString(){
        return a+"\n"+b;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.writeObject(b);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
//        b = (String) in.readObject();
    }

    public static void main(String[] args) {
        SerialCtl1 sc = new SerialCtl1("Test1","Test2");
        System.out.println("Before:\n"+sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            ObjectOutputStream out1 = new ObjectOutputStream(buf);
            out1.writeObject(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
            SerialCtl1 sc1 = (SerialCtl1) in1.readObject();
            System.out.println("After:\n"+sc1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
