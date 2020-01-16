package com.oscar.service;

import com.oscar.entity.BrandRank;
import com.oscar.util.ExcelUtil;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <code>ExcelOperateService</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/3
 * @version: 1.0
 */
@Service
public class ExcelOperateService implements IExcelOperateService{

    @Override
    public List<BrandRank.Brand> initBrands(){
        List<BrandRank.Brand> list = new ArrayList<BrandRank.Brand>();
        BrandRank.Brand brand = new BrandRank.Brand();
        brand.setName("蚂蚁金服");
        brand.setRank("第一名");
        list.add(brand);
        BrandRank.Brand brand1 = new BrandRank.Brand();
        brand1.setName("陆金所");
        brand1.setRank("第二名");
        list.add(brand1);
        return list;
    }

    public byte[] exportExcel(BrandRank brandRank){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String[] titles = {"品牌名称","名次"};
//        List<BrandRank.Brand> list = brandRank.getList();
        List<BrandRank.Brand> list = initBrands();
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("品牌排名");
        ExcelUtil excelUtil = new ExcelUtil(wb,sheet);
        XSSFCellStyle headStyle = excelUtil.getHeadStyle();
        XSSFCellStyle bodyStyle = excelUtil.getBodyStyle();
        XSSFRow headRow = sheet.createRow(0);
        XSSFCell cell = null;
        for(int i=0;i<titles.length;i++){
            cell = headRow.createCell(i);
            cell.setCellStyle(headStyle);
            cell.setCellValue(titles[i]);
        }
        for(int i=0;i<list.size();i++){
            BrandRank.Brand brand = list.get(i);
            XSSFRow bodyRow = sheet.createRow(i + 1);
            cell = bodyRow.createCell(0);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(brand.getName());

            cell = bodyRow.createCell(1);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(brand.getRank());
        }
        try {
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}
