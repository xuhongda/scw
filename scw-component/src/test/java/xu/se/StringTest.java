package xu.se;

import org.junit.Test;

/**
 * @authorxuhongda on 2017/11/11
 * com.xu.se
 * scw-parent
 */
public class StringTest {
    /**
     * null和空的区别
     */
    @Test
    public void testNull(){
        String string=new String();
        System.out.println(string.isEmpty());
        System.out.println(string==null);
    }
}
