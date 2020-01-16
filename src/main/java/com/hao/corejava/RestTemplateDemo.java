package com.hao.corejava;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>RestTemplateDemo</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/2
 * @version: 1.0
 */
public class RestTemplateDemo {
    public static void main(String[] args){
        String url = "http://172.21.64.24:8083/count?str={str}&union={union}";
        Map<String,String> params = new HashMap<String,String>();
        params.put("str","(39.940840237577746,116.42916387146184,1500.0)");
        params.put("union","or");
        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> re = restTemplate.postForEntity(url,null,String.class,params);
        String re = restTemplate.getForObject(url,String.class,"(39.940840237577746,116.42916387146184,1500.0)","or");
        System.out.println(re);
//        if(re.getStatusCode() == HttpStatus.OK){
//            System.out.println(re.getBody());
//        }
    }


}
