package xu.se;

import org.junit.Test;

/**
 * @authorxuhongda on 2017/12/12
 * xu.se
 * scw-parent
 */
public class ArryTest {
   @Test
    public void test(){
       //定义一个 int[] 类型的数组变量
       int[] iArr;
       //动态初始化数组, 数组长度为5
       iArr = new int[5];
       //采用循环方式为每个数组元素赋值
       for (int i = 0; i < iArr.length; i++)
       {
           iArr[i] = i + 10;
       }
       //使用 foreach 循环输出数组
       for (int temp : iArr)
       {
           System.out.println(temp);
       }
   }
}
