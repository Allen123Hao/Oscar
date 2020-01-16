package com.oscar.controller;

import com.oscar.service.DemoService;
import com.oscar.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <code>DemoController</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/10/31
 * @version: 1.0
 */
@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;
    @RequestMapping(value="toPage1.do")
    public ModelAndView toPage1(){
        System.out.println("go into toPage1");
//        DemoService demoService = SpringContextUtil.getApplicationContext().getBean("demoService",DemoService.class);
        demoService.printPage1();
        return new ModelAndView("page1");
    }

    @RequestMapping(value="login.do",method = RequestMethod.GET,produces = "application/json")
    public Object post(@RequestParam(value="userIds") String userId){
        System.out.println(userId);
        Map<String,String> resMap = new HashMap<String,String>();
        resMap.put("code", "200");
        resMap.put("desc", "success");
        return resMap;
    }
    @RequestMapping(value="test1.do",method = RequestMethod.GET)
    @ResponseBody
    public Object test1(@RequestParam(value="userId") String userId){
        System.out.println("go into test1:"+userId);
        Map<String,String> resMap = new HashMap<String,String>();
        resMap.put("code","200");
        resMap.put("desc", "success");
        return resMap;
    }
    @RequestMapping(value="test2.do",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object test2(@RequestBody String userId){
        System.out.println("go into test2:"+userId);
        Map<String,String> resMap = new HashMap<String,String>();
        resMap.put("code","200");
        resMap.put("desc", "success");
        return resMap;
    }
    @RequestMapping(value="test3.do",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object test3(@RequestParam(value = "userId") Integer userId){
        System.out.println("go into test3:"+userId);
        Map<String,String> resMap = new HashMap<String,String>();
        resMap.put("code","200");
        resMap.put("desc", "success");
        return resMap;
    }
    @RequestMapping(value="test4.do",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public Object test4(@RequestBody Integer userId){
        System.out.println("go into test4:"+userId);
        Map<String,String> resMap = new HashMap<String,String>();
        resMap.put("code","200");
        resMap.put("desc", "success");
        return resMap;
    }
}
