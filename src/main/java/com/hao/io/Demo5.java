package com.hao.io;

import java.io.*;

/**
 * <code>Demo5</code>
 *
 * @description: Externalizable和Serializable
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/3/13
 * @version: 1.0
 */
public class Demo5 implements Externalizable{
    private static final long serialVersionUID = 8364988832581114038L;
    private String a;
    private transient String b;

    //Externalizable必须存在无参构造方法
    public Demo5(){

    }

    public Demo5(String aa, String bb){
        this.a="Not Transient:"+aa;
        this.b="Transient:"+bb;
    }

    public String toString(){
        return a+"\n"+b;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(a);
        out.writeUTF(b);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        a = in.readUTF();
        b = in.readUTF();
    }

    public static void main(String[] args) {
        Demo5 sc = new Demo5("Test1","Test2");
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
            Demo5 sc1 = (Demo5) in1.readObject();
            System.out.println("After:\n"+sc1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
