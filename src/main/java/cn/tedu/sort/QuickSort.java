package cn.tedu.sort;

import java.util.Random;

/**
 * @Author lkh
 */
public class QuickSort {
    //private Integer[] arr;
    //private int n;
    //public QuickSort(){
    //    
    //}
    //public QuickSort(Integer[] arr,int n){
    //    this.arr=arr;
    //    this.n=n;
    //}
    public void quickSort(Integer[] arr,int n){
        quickSort(arr,0,n-1);
    }
    private void quickSort(Integer[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p=partition2(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    /**
     * 返回p，使得arr[l...p-1]<arr[p] arr[p+1...r]>arr[p]
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int partition(Integer[] arr, int l, int r) {
        //Random random=new Random();
        //int tem=arr[random.nextInt()%(r-l+1)+l];
        //arr[random.nextInt()%(r-l+1)+l]=arr[l];
        //arr[l]=tem;
        int v=arr[l];
        int j=l;
        for (int i=l+1;i<=r;i++){
            if (arr[i] < v) {
                int temp=arr[j+1];
                arr[j+1]=arr[i];
                arr[i]=temp;
                j++;
            }
        }
        int temp=arr[l];
        arr[l]=arr[j];
        arr[j]=temp;
        return j;
    }
    private int partition2(Integer[] arr, int l, int r){
        int v=arr[l];
        //i表示arr[l+1...i] <=v arr[j...r]>=v
        int i=l+1,j=r;
        while (true) {
            while (i<=r&&arr[i] < v) {
                i++;
            }
            while (j>=l+1&&arr[j] > v) {
                j--;
            }
            if (i > j) {
                break;
            }
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        int temp=arr[l];
        arr[l]=arr[j];
        arr[j]=temp;
        return j;
    }

    /**
     * 三路快速排序
     */
    public void quickSortThreeWWays(Integer[] arr,int n){
        quickSortThreeWWays(arr,0,n-1);
    }

    /**
     * 三路快速排序 将元素分为<v ==v  >v
     * @param arr
     * @param l
     * @param r
     */
    private void quickSortThreeWWays(Integer[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //int temp=arr[l];
        //arr[l]=arr[new Random().nextInt()%(r-l+1)+l];
        //arr[new Random().nextInt()%(r-l+1)+l]=temp;
        int v=arr[l];
        int lt=l;
        int gt=r+1;
        int i=l+1;
        while (i < gt) {
            if (arr[i] < v) {
                int temp2=arr[i];
                arr[i]=arr[lt+1];
                arr[lt+1]=temp2;
                lt++;
                i++;
            } else if (arr[i] > v) {
                int temp3=arr[i];
                arr[i]=arr[gt-1];
                arr[gt-1]=temp3;
                gt--;
            }else {
                i++;
            }
        }
        int temp4=arr[l];
        arr[l]=arr[lt];
        arr[lt]=temp4;
        quickSortThreeWWays(arr,l,lt-1);
        quickSortThreeWWays(arr,gt,r);
    }

    public static void main(String[] args) {
        int n=1000000;
        Integer[] arr=new SortTestHelper().generateRandomArray(n,0,n);
        long start=System.nanoTime();
        QuickSort sort=new QuickSort();
        sort.quickSort(arr,n);
        long end=System.nanoTime();
        System.out.println((end-start)/1000000000.0);
        long start1=System.nanoTime();
        sort.quickSortThreeWWays(arr,n);
        long end1=System.nanoTime();
        System.out.println((end1-start1)/1000000000.0);
    }
    //public void swap(int i,int j){
    //    int temp=i;
    //    i=j;
    //    j=temp;
    //}

}
