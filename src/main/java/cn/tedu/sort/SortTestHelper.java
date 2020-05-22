package cn.tedu.sort;

import java.util.Random;

/**
 * @Author lkh
 */
public class SortTestHelper {
    /**
     * 生成n个元素的随机数组
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public Integer[] generateRandomArray(int n,int rangeL,int rangeR){
        Integer[] arr=new Integer[n];
        Random random=new Random();
        if (rangeL > rangeR) {
            throw new IllegalArgumentException("数组范围错误");
        }
        for (int i=0;i<n;i++){
            arr[i]=random.nextInt(Integer.MAX_VALUE)%(rangeR-rangeL+1)+rangeL;
        }
        return arr;
    }

    public static void main(String[] args) {
        SortTestHelper helper=new SortTestHelper();
        Integer[] arr=helper.generateRandomArray(10,100,200);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
