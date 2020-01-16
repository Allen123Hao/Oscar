package com.hao.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * <code>Demo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/1
 * @version: 1.0
 */
public class Demo1 {
    public InputStream fun1(){
        File file = new File("D:\\dest\\logo.jpg");
        InputStream is = null;
        try {
            is  = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return is;
    }
    public static void main(String[] args){
        Demo1 demo1 = new Demo1();
        InputStream is = demo1.fun1();
        try {
            BufferedImage image = ImageIO.read(is);
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println(String.format("width*height:%s*%s", width,height));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
