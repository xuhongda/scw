package xu.se;

import org.junit.Test;

/**
 * 回顾循环嵌套
 */
public class ForTest {
    @Test
    public  void testForCirculation() {
        for (int i = 0; i <4 ; i++) {
            System.out.println("xixi");
            for (int j = 0; j <3 ; j++) {
                System.out.print("哈哈"+" ");
            }
            System.out.println();
        }
    }

}
