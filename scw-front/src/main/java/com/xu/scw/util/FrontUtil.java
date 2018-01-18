package com.xu.scw.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class FrontUtil {

    public static String http(String url,HttpMethod method, Map<String,String> params,Map<String,String> headers){

        //1、使用它发请求
        RestTemplate restTemplate = new RestTemplate();

        //2、装请求参数
        MultiValueMap<String,String> mvp = new LinkedMultiValueMap<>();
        //将传递过来的简单map数据，放在mvp里面
        if(params!=null && !params.isEmpty()){
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                mvp.add(key,value);
            }
        }

        //3、请求头
        HttpHeaders requestHeaders = new HttpHeaders();
        if(headers!=null && !headers.isEmpty()){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                requestHeaders.add(entry.getKey(),entry.getValue());
            }
        }

        HttpEntity<MultiValueMap<String,String>> paramsMap = new HttpEntity<MultiValueMap<String,String>>(mvp,requestHeaders);

        //

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, method, paramsMap, String.class);

        return responseEntity.getBody();
    }
}
