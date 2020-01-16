package com.hao.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <code>NetWorkClassLoader</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/6/12
 * @version: 1.0
 */
public class NetWorkClassLoader extends ClassLoader{
    private String rootUrl;

    public NetWorkClassLoader(String rootUrl){
        this.rootUrl = rootUrl;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException{
        Class<?> clazz = findLoadedClass(name);
        if(clazz == null){
            System.out.println("can't load from AppClassLoader");
            return findClass(name);
        }
        return null;

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        System.out.println("开始findClass……");
        Class clazz = null;
        byte[] classData = getClassData(name);
        if(classData == null){
            throw new ClassNotFoundException();
        }
        clazz = defineClass(name,classData,0,classData.length);
        return clazz;
    }

    private byte[] getClassData(String name){
        InputStream inputStream = null;
        String path = classNameToPath(name);
        System.out.println("path:"+path);
        try {
            URL url = new URL(path);
            byte[] bytes = new byte[1024*4];
            int len = -1;
            inputStream = url.openStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while((len = inputStream.read(bytes)) != -1){
                baos.write(bytes,0,len);
            }
            return baos.toByteArray();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    private String classNameToPath(String name){
        return rootUrl + "/" + name.replace(".","/") + ".class";
    }
}
