package com.oscar.entity;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * <code>UploadFile</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/3/6
 * @version: 1.0
 */
public class UploadFile {
    private CommonsMultipartFile file;
    private String fileName;
    private String fileMD5;

    public CommonsMultipartFile getFile() {
        return file;
    }

    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMD5() {
        return fileMD5;
    }

    public void setFileMD5(String fileMD5) {
        this.fileMD5 = fileMD5;
    }
}
