package cn.tedu;

import cn.tedu.sort.InsertSort;
import cn.tedu.sort.SelectionSort;
import org.junit.Test;

/**
 * @Author lkh
 */
public class SortTest {
    @Test
    public void test1(){
        SelectionSort sort=new SelectionSort();
        Integer[] a={1,2,3,4,5,6};
        Integer[] arr= (Integer[]) sort.copyArray(a,a.length);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    @Test
    public void test2(){
        InsertSort<Integer> sort=new InsertSort<>();
        Integer[] a={3,5,7,2,4,8,9};
        Integer[] b=sort.insertionSort(a,a.length);
        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
    @Test
    public void test3(){
        int[] arr={3,4};
        swap(arr[0],arr[1]);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        
    }
    public void swap(int i,int j){
        int temp=i;
        i=j;
        j=temp;
    }

}
