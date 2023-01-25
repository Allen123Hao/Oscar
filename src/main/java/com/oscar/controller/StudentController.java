package com.oscar.controller;

import com.oscar.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <code>StudentController</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2022-12-08
 * @version: 1.0
 */
@Controller
public class StudentController {

    @Autowired
    private TestService testService;

    @RequestMapping("/student/query")
    private String queryStudent(){
        testService.queryStudent();
        return "success";
    }
}
