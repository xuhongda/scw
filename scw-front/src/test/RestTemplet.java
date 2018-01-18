import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import com.xu.scw.bean.TUser;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @authorxuhongda on 2017/12/10
 * PACKAGE_NAME
 * scw-parent
 */
public class RestTemplet {
    @Test
    public void  testType(){
        //返回结果泛型支持
        ParameterizedTypeReference<TUser> parameterizedTypeReference = new ParameterizedTypeReference<TUser>() {
        };

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity entity = new HttpEntity(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        String url ="http://localhost:8080/scw/front/restTest";
        Map<String,Object> map = new HashMap(16);
        map.put("id","1");
        map.put("age","18");
        map.put("type",new TUser());
        ResponseEntity<TUser> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, parameterizedTypeReference, map);

    }
}
