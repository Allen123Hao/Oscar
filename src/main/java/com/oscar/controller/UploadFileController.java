package com.oscar.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <code>UploadFileController</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/16
 * @version: 1.0
 */
@Controller
public class UploadFileController {
    @RequestMapping(value="/uploadImage.do",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public Object upload(@RequestParam(value="file1")CommonsMultipartFile file,@RequestParam(value="userId")String userId,
                         @RequestParam(value="userName") String userName){
        System.out.println("userId:"+userId);
        System.out.println("userName:"+userName);
        String name = file.getOriginalFilename();
        System.out.println("The name of file:" + name);
        String[] partNames = name.split("\\.");
        if(partNames.length <=1){
            System.out.println("未找到图片的后缀名！");
        }
        String suffix = partNames[partNames.length-1];
        String storage = file.getStorageDescription();
        System.out.println("The storage of file:"+storage);
        long size = file.getSize();
        System.out.println("The size of file:"+size);
        /**
        File desFile = new File("D:\\dest\\"+name);
        if(!desFile.exists()){
            desFile.mkdirs();
        }
        try {
            file.transferTo(desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedImage sourceImage = ImageIO.read(new FileInputStream(desFile));
            int height = sourceImage.getHeight();
            int width = sourceImage.getWidth();
            System.out.println("The height of file:"+height);
            System.out.println("The width of file:"+width);
        } catch (IOException e) {
            e.printStackTrace();
        }
         **/
        Map<String,String> retMap = new HashMap<String,String>();
        retMap.put("code","200");
        retMap.put("desc","success");
        return retMap;
    }
}
