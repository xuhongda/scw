import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @authorxuhongda on 2017/12/11
 * PACKAGE_NAME
 * scw-parent
 */
public class RestTemp {
    @Test
    public void test(){
        String url="http://localhost:8080/scw/api/temp";
        /*restTempt发送参数*/
        RestTemplate template = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        MultiValueMap<String,String> mvp = new LinkedMultiValueMap<>();
        mvp.add("acct","admin");
        HttpEntity<String> requestEntity = new HttpEntity(mvp,requestHeaders);
        template.postForObject(url,requestEntity
        ,String.class);


    }

    /**
     * 注意get请求方式是请求头，不含请求体，所以map带参数，会被当成uri
     * 可以采取以下面的方式写，明确指出参数
     *
     */
    @Test
    public void testGet(){
        String url="http://localhost:8080/scw/api/temp?acct={acct}";
        /*restTempt发送参数*/
        RestTemplate template = new RestTemplate();
        Map map = new HashMap(16);
        map.put("acct","hello");
        //get
        template.getForObject(url,String.class,map);
    }

    /**
     * 必须post
     * 不能使用普通map
     * 使用MultiValueMap
     */
    @Test
    public void testExc(){
        String url="http://localhost:8080/scw/api/temp";
        HttpHeaders requestHeaders = new HttpHeaders();

        RestTemplate template = new RestTemplate();
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("acct","admin");
        requestHeaders.set("hi", "h");
        HttpEntity<MultiValueMap<String,String>> requestEntity = new HttpEntity(map,requestHeaders);

        HttpEntity<String> response = template.exchange(
                url,
                HttpMethod.POST, requestEntity, String.class);

    }
}

