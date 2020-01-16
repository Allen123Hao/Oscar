package com.oscar.controller;

import com.oscar.entity.BrandRank;
import com.oscar.service.ExcelOperateService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * <code>ExportExcelController</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/3
 * @version: 1.0
 */
@RestController
public class ExcelController {
    @Autowired
    private ExcelOperateService excelOperateService;

    /**
     * {"industry":"金融app","list":[{"name":"蚂蚁金服","rank":"第一名"},{"name":"陆金所","rank":"第二名"}]}
     * @param brandRank
     * @return
     */
    @RequestMapping(value="/export.do",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Object exportExcel(@RequestBody(required = false) BrandRank brandRank,HttpServletResponse response){
        System.out.println("go into ExportExcelController.exportExcel");
//        response.setContentType("application/binary;charset=ISO8859_1");
        byte[] bytes = excelOperateService.exportExcel(brandRank);
//        byte[] filename = null;
//        try {
//            filename = ("金融App排名").getBytes("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        byte[] fileNameByte;
        String filename = null;
        try {
            fileNameByte = ("金融App排名").getBytes("UTF-8");
            filename = new String(fileNameByte, "ISO8859-1");
            System.out.println("filename:"+filename);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        response.setContentType("application/x-msdownload");
        response.setContentType("application/vnd.ms-excel");
        response.setContentLength(bytes.length);
        response.setHeader("Content-Disposition", "attachment;filename=" + filename +".xlsx");

        try {
            OutputStream os = response.getOutputStream();
            os.write(bytes);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";

    }
    @RequestMapping(value="/exceldownload.do",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object downloadExcel(HttpServletRequest request,HttpServletResponse response){
        String userId = request.getParameter("userId");
        System.out.println(userId);
//        File file = new File("员工名单.xlsx");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + userId+".xlsx");
        try {
            OutputStream outputStream = response.getOutputStream();
            HSSFWorkbook workBook = new HSSFWorkbook();
            workBook.createSheet("员工名单");
            workBook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,String> map = new HashMap<String,String>();
        map.put("result","success");
        return map;
    }

    @RequestMapping("excelupload.do")
    public ModelAndView uploadExcel(HttpServletRequest request,HttpServletResponse response){
        MultipartHttpServletRequest multRequest = null;
        try {
            multRequest = (MultipartHttpServletRequest) request;
        } catch (Exception e) {
            e.printStackTrace();
        }
        MultipartFile multipartFile = multRequest.getFile("file");
        String fileName = multipartFile.getOriginalFilename();
        if(fileName == null || "".equals(fileName)){
            return null;
        }
        try {
            InputStream is = multipartFile.getInputStream();
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            if(sheet != null){
                for(int i=0;i<sheet.getPhysicalNumberOfRows();i++){
                    XSSFRow row = sheet.getRow(i);
                    for(int j=0;j<row.getPhysicalNumberOfCells();j++){
                        XSSFCell cell = row.getCell(j);
                        String cellStr = cell.toString();
                        System.out.print("【" + cellStr + "】");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView("excel");
    }

    @RequestMapping(value="imageupload.do")
    public ModelAndView uploadPicture(HttpServletRequest request,HttpServletResponse response){
        MultipartHttpServletRequest multRequest = null;
        try {
            multRequest = (MultipartHttpServletRequest) request;
        } catch (Exception e) {
            e.printStackTrace();
        }
        MultipartFile multipartFile = multRequest.getFile("file");
        String fileName = multipartFile.getOriginalFilename();
        if(fileName == null || "".equals(fileName)){
            return null;
        }
        try {
            InputStream is = multipartFile.getInputStream();
            File file = new File("E:/Oscar/upload/"+fileName);
            if(!file.exists()){
                file.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return new ModelAndView("excel");
    }

    @RequestMapping(value="/test.do",method=RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public ModelAndView test(@RequestParam(value="name")String name,@RequestParam(value="password")String password){
        System.out.println("go into ExportExcelController.test");
        System.out.println(name + ":" + password);
        return new ModelAndView("excel");
    }

    @RequestMapping(value="/excel.do")
    @ResponseBody
    public ModelAndView test(){
        System.out.println("go into ExportExcelController.test");
        return new ModelAndView("excel");
    }

}
