package com.hao.corejava;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * <code>TypeDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-09-13
 * @version: 1.0
 */
public class TypeDemo<T> {
    // GenericArrayType：组件类型为类型变量的数组
    public T[] a;
    // GenericArrayType：组件类型为参数化类型的数组
    public List<?>[] b;
    // ParameterizedType：参数化类型
    // List<? extends Object>携带的"? extends Object"
    // 即通配符表达式，也就是WildcardType
    public List<? extends Object> c;
    // Class：普通类型
    public List d;
    // 类型变量
    public T e;


    public static void getType(String fieldName) throws Exception{
        Field field = TypeDemo.class.getDeclaredField(fieldName);
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArg : actualTypeArguments) {
                System.out.println(actualTypeArg.getClass());
                System.out.println(actualTypeArg.getTypeName());
            }
        }
        if(type instanceof GenericArrayType){
            GenericArrayType genericArrayType = (GenericArrayType) type;
            Type actualType = genericArrayType.getGenericComponentType();
            System.out.println(actualType.getClass());
            System.out.println(actualType.getTypeName());
        }
    }

    public static void main(String[] args) throws Exception{
        TypeDemo.getType("c");
        TypeDemo.getType("b");
        TypeDemo.getType("a");
    }
}
