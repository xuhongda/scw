package xu.test;

import com.xu.scw.dao.TTokenMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @authorxuhongda on 2017/12/2
 * com.xu.test
 * scw-parent
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml",
        "classpath:spring-mybatis.xml",
        "classpath:spring-tx.xml"})

public class UUidTest {
    @Autowired
    TTokenMapper tTokenMapper;

    @Test
    public void test001(){
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        System.out.println(s);

    }
}
