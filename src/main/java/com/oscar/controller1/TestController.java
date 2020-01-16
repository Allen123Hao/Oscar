package com.oscar.controller1;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * <code>TestController</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2017/3/6
 * @version: 1.0
 */
@RestController
public class TestController {
    @RequestMapping(value="hello",method = RequestMethod.GET)
    public Object helloWorld(@RequestParam(value = "name",required = false) String name){
        System.out.println("name:"+name);
//        return name;
        return new ModelAndView("hello");
    }
    @RequestMapping(value="usedtimes",method = RequestMethod.GET)
    @ResponseBody
    public Object getUseTimesInfo(@RequestParam(value="userId") Integer userId,
                                                          @RequestParam(value="startDate") String startDate,
                                                          @RequestParam(value="endDate") String endDate){
        System.out.println("go into getUseTimesInfo===");
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("userId",userId);
        hashMap.put("startDate",startDate);
        hashMap.put("endDate",endDate);
        return hashMap;
    }

}
