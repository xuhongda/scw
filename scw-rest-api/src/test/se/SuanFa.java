package se;

import org.junit.Test;


/**
 * @authorxuhongda on 2017/12/14
 * se
 * scw-parent
 */
public class SuanFa {
    @Test
    public void test(){

      int [] arr =new  int[] {1,32,6,80,33};
        int max=arr[0] ;
      for(int i =0;i<arr.length;i++){
          if (max<arr[i]){
                max=arr[i];
          }
      }
        System.out.println(max);
    }

    /**
     * 冒泡排序
     */
    @Test
    public void testErFen(){
        int [] arr =new  int[] {1,32,6,80,33,9,32,3,6,0};
        int temp =arr[0];
       for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-j;j++){
                if(arr[j]<arr[j+1]){
                    temp=arr[j+1];
                }
            }
        }
        System.out.println(temp);
    }
}
