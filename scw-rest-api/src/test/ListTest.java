import org.junit.Test;

import java.util.*;

/**
 * @authorxuhongda on 2017/12/13
 * PACKAGE_NAME
 * scw-parent
 */
public class ListTest {
    @Test
    public void test(){
        List list = new ArrayList(90);
        System.out.println(list.get(18));
    }

    /**
     * 算法，时间复杂度
     */
    @Test
    public void testO(){
        int[] arr = new int[9999999];
        List list = new ArrayList(9999999);
        long l = System.currentTimeMillis();
        //比较添加速度
        for(int i=0;i<9999999;i++){
           // arr[i]=i;//39ms
            list.add(i);//5363
        }
        //遍历
       /* for(int arr1:arr){
            //6ms
        }*/
        for(int x=0;x<list.size();x++){
           // System.out.println(list.size());
        }
        long l1 = System.currentTimeMillis();

        System.out.println(l1-l);

    }
}
