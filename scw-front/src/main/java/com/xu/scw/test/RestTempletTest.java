package com.xu.scw.test;


import com.xu.scw.bean.TUser;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * @authorxuhongda on 2017/12/9
 * com.xu.scw.test
 * scw-parent
 */
public class RestTempletTest {
    @Test
    public void templetTest(){

       /* ParameterizedTypeReference<TUser> parameterizedTypeReference = new ParameterizedTypeReference() {
        };
*/
        HttpHeaders requestHeaders = new HttpHeaders();

        RestTemplate template = new RestTemplate();
        MultiValueMap<String,Object> multiValueMap =new LinkedMultiValueMap<>();
        Map<String,Object> map = new HashMap(16);
        multiValueMap.add("String","aa");
        multiValueMap.add("String","dvasdv");

        map.put("String","1");
        map.put("String","2");
        HttpEntity<String> requestEntity = new HttpEntity(multiValueMap,requestHeaders);

        String url ="http://localhost:8080/scw/front/rest";

       // String forObject = template.getForObject(url, String.class, map);
        ResponseEntity<String> exchange = template.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String body = exchange.getBody();
        System.out.println(body);

    }


}
