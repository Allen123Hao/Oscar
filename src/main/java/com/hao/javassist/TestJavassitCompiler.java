package com.hao.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;

import java.io.File;
import java.io.FileOutputStream;

/**
 * <code>TestJavassitCompiler</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-04-24
 * @version: 1.0
 */
public class TestJavassitCompiler {

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.hao.javassist.Emp");
        //添加属性:private String name
        CtField nameField = new CtField(pool.getCtClass("java.lang.String"), "name", ctClass);
        nameField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(nameField);
        //添加属性:private int account
        CtField accountField = new CtField(pool.getCtClass("int"), "account", ctClass);
        accountField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(accountField);
        //getter和setter
        ctClass.addMethod(CtNewMethod.getter("getName", nameField));
        ctClass.addMethod(CtNewMethod.setter("setName", nameField));
        ctClass.addMethod(CtNewMethod.getter("getAccount", accountField));
        ctClass.addMethod(CtNewMethod.setter("setAccount", accountField));
        //创建无参构造器
        CtConstructor ctConstructor = new CtConstructor(new CtClass[] {}, ctClass);
        String body = new StringBuilder("{\nthis.account = 1;\nthis.name = \"xiaona\";\n}").toString();
        ctConstructor.setBody(body);
        ctClass.addConstructor(ctConstructor);
        //有参参数
        CtConstructor cc = new CtConstructor(new CtClass[]{pool.get("java.util.List")}, ctClass);
        cc.setBody("{\n$1.get(0);\n$1.get(1);}");
        ctClass.addConstructor(cc);

        //普通方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "commonMethod", new CtClass[] {}, ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody(new StringBuilder("{\n System.out.println(\"haha\"); \n}").toString());
        ctClass.addMethod(ctMethod);

        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();
        obj.getClass().getMethod("commonMethod", new Class[] {}).invoke(obj, new Object[] {});//方法调用

        /**
         * 将字节码输出到文件中
         */
        byte[] codeByteArray = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("/Users/haoxueqiang/Downloads/Emp.class"));
        fos.write(codeByteArray);
        fos.close();
    }
}
