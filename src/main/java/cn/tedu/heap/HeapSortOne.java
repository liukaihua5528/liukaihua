package cn.tedu.heap;

import cn.tedu.sort.SortTestHelper;

/**
 * @Author lkh
 */
public class HeapSortOne {
    public void heapSortOne(Integer[] arr,int n){
        MaxHeap maxHeap=new MaxHeap(n);
        for (int i=0;i<n;i++){
            maxHeap.insert(arr[i]);
        }
        for (int i=n-1;i>0;i--){
            arr[i]=maxHeap.extractMax();
        }
    }
    public void heapSortTwo(Integer[] arr,int n){
        MaxHeap maxHeap=new MaxHeap(arr,n);
        for (int i=n-1;i>0;i--){
            arr[i]=maxHeap.extractMax();
        }
    }
    public void heapSort(Integer[] arr,int n){
        for (int i=(n-1)/2;i>=0;i--){
            shiftDownTwo(arr,n,i);
        }
        for (int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            shiftDownTwo(arr,i,0);
        }
    }

    private void shiftDownTwo(Integer[] arr, int n, int k) {
        //有左孩子就有右孩子
        while (2 * k+1 <= n) {
            int j=2*k+1;//在此轮循环中，data[k]和data[j]交换位置
            if (j + 1 < n&&arr[j+1]>arr[j]) {
                j+=1;
            }
            if (arr[k]>=arr[j]){
                break;
            }
            int temp=arr[k];
            arr[k]=arr[j];
            arr[j]=temp;
            k=j;
        }
    }

    public static void main(String[] args) {
        HeapSortOne one=new HeapSortOne();
        Integer[] arr= new SortTestHelper().generateRandomArray(10000000,0,10);
        long start=System.nanoTime();
        one.heapSortOne(arr,10000000);
        long end=System.nanoTime();
        System.out.println((end-start)/1000000000.0);
        long start1=System.nanoTime();
        one.heapSortTwo(arr,10000000);
        long end1=System.nanoTime();
        System.out.println((end1-start1)/1000000000.0);
        long start2=System.nanoTime();
        one.heapSort(arr,10000000);
        long end2=System.nanoTime();
        System.out.println((end2-start2)/1000000000.0);
    }

}
