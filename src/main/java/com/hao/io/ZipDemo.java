package com.hao.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * <code>ZipDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/3
 * @version: 1.0
 */
public class ZipDemo {



    private void func1() throws IOException{
        String dirPath = "/Users/haoxueqiang/test/test1";
        File zipFile = new File(dirPath,"hao.zip");
        ZipOutputStream zos  = new ZipOutputStream(new FileOutputStream(zipFile));
        BufferedOutputStream bos = new BufferedOutputStream(zos);
        ZipEntry zipEntry1 = new ZipEntry("a.txt");
        zos.putNextEntry(zipEntry1);
        BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream("/Users/haoxueqiang/test/test1/a.txt"));
        int count1 = 0;
        byte[] bytes1 = new byte[1024];
        if((count1 = bis1.read(bytes1,0,bytes1.length)) != -1){
            bos.write(bytes1,0,count1);
        }
        bos.flush();
        bis1.close();


        ZipEntry zipEntry2 = new ZipEntry("b.txt");
        zos.putNextEntry(zipEntry2);
        BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream("/Users/haoxueqiang/test/test1/b.txt"));
        int count2 = 0;
        byte[] bytes2 = new byte[1024];
        if((count2 = bis2.read(bytes2,0,bytes2.length)) != -1){
            bos.write(bytes2,0,count2);
        }
        bos.flush();
        bis2.close();

        ZipEntry zipEntry3 = new ZipEntry("c.txt");
        zos.putNextEntry(zipEntry3);
        BufferedInputStream bis3 = new BufferedInputStream(new FileInputStream("/Users/haoxueqiang/test/test1/b.txt"));
        int count3 = 0;
        byte[] bytes3 = new byte[1024];
        if((count3 = bis3.read(bytes3,0,bytes3.length)) != -1){
            bos.write(bytes3,0,count3);
        }
        bos.flush();
        bis3.close();
        bos.close();

        zos.close();

        System.out.println(zipFile.getAbsolutePath());


    }

    public void func2() throws IOException{
        String dirPath = "/Users/haoxueqiang/test/test1";
        File dirFile = new File(dirPath);
        File zipFile = new File(dirPath,"hao1.zip");
        ZipOutputStream zos  = new ZipOutputStream(new FileOutputStream(zipFile));
        BufferedOutputStream bos = new BufferedOutputStream(zos);
        for(File file : dirFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir,String name) {
                System.out.println("filterdir:"+dir.getAbsolutePath());
                System.out.println("filtername:"+name);
                if(name.indexOf(".zip") > -1){
                    return false;
                }
                return true;
            }
        })){
            System.out.println("listFiles:"+file.getAbsolutePath());
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            int count = 0;
            byte[] bytes = new byte[1024];
            if((count = bis.read(bytes,0,bytes.length)) != -1){
                bos.write(bytes,0,count);
            }
            bos.flush();
            bis.close();
        }
        bos.close();
        zos.close();

    }

    public static void main(String[] args) throws Exception {
        ZipDemo zipDemo = new ZipDemo();
        zipDemo.func1();
    }
}
