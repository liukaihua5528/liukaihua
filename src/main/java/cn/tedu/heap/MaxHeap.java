package cn.tedu.heap;

import java.util.Comparator;
import java.util.Random;

/**
 * @Author lkh
 */
public class MaxHeap {
    private Integer[] data;
    private int count;
    private int capacity;
    public MaxHeap(int capacity){
        this.capacity=capacity;
        data= new Integer[capacity+1];
        count=0;
    }
    public MaxHeap(Integer[] arr,int n){
        data=new Integer[n+1];
        capacity=n;
        for (int i=0;i<n;i++){
            data[i+1]=arr[i];
        }
        count=n;
        for (int i=count/2;i>=1;i--){
            shiftDown(i);
        }
    }
    public int getSize(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }
    public void insert(Integer t){
        if (count + 1 <= capacity) {
            data[count+1]=t;
            count++;
            shiftUp(count);
        }
    }
    
    private void shiftUp(int k) {
        while (k>1&&data[k/2]<data[k]){
            int temp=data[k/2];
            data[k/2]=data[k];
            data[k]=temp;
            k/=2;
        }
    }
    public Integer extractMax(){
        if (count < 0) {
            throw new IllegalArgumentException("count <0");
        }
        Integer ret=data[1];
        int temp=data[1];
        data[1]=data[count];
        data[count]=temp;
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        //有左孩子就有右孩子
        while (2 * k <= count) {
            int j=2*k;//在此轮循环中，data[k]和data[j]交换位置
            if (j + 1 <= count&&data[j+1]>data[j]) {
                j+=1;
            }
            if (data[k]>=data[j]){
                break;
            }
            int temp=data[k];
            data[k]=data[j];
            data[j]=temp;
            k=j;
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap=new MaxHeap(100);
        System.out.println(maxHeap.getSize());
        Random random=new Random();
        for (int i=0;i<50;i++){
            maxHeap.insert(random.nextInt(100));
        }
        //for (int i=1;i<maxHeap.getSize()+1;i++){
        //    System.out.println(maxHeap.data[i]);
        //}
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.extractMax());
        }
    }

}
