package com.hao.corejava;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * <code>AppTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/16
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args){
        try {
            InputStream is = new FileInputStream("D:/dest/logo.jpg");
            BufferedImage image = ImageIO.read(is);
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println(width+"*"+height);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
