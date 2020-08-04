package cn.tedu.algorithm.heap;

import org.junit.Test;

import java.util.Random;

/**
 * @Date 2020/8/3 21:29
 * @Created by liukaihua
 */
public class HeapTest {

    private static double testHeap(Integer[] testData,boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for (int num:testData){
                maxHeap.add(num);
            }
        }
        int[] arr = new int[testData.length];
        for (int i=0;i<testData.length;i++){
            arr[i] = maxHeap.extractMax();
        }
        for (int i=1;i<testData.length;i++){
            if (arr[i-1]<arr[i]){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("success");
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i=0;i<n;i++){
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = heap.extractMax();
        }
        for (int i=1;i<n;i++){
            if (arr[i-1]<arr[i]){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("success");
    }

    @Test
    public void testHeap(){
        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i=0;i<n;i++){
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData,false);
        System.out.println(time1);
        double time2 = testHeap(testData,true);
        System.out.println(time2);
    }

}
