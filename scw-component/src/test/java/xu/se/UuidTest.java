package xu.se;

import org.junit.Test;

import java.util.UUID;

/**
 * @authorxuhongda on 2017/12/7
 * com.xu.se
 * scw-parent
 */
public class UuidTest {
    @Test
    public void test001(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().substring(2, 7).replace("-", "3"));
    }
}
