package cn.tedu.sort;

/**
 * 归并排序
 * @Author lkh
 */
public class MergeSort {
    private Integer[] arr;
    private int n;
    public MergeSort(){
        
    }
    public MergeSort(Integer[] arr,int n){
        this.arr=arr;
        this.n=n;
    }
    public void mergeSort(Integer[] arr,int n){
        mergeSort(arr,0,n-1);
    }

    public void mergeSort(Integer[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //if (r - l <= 15) {
        //    return;
        //}
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public void merge(Integer[] arr,int left,int mid,int right){
        Integer[] temp=  new Integer[right-left+1];
        for (int i=left;i<=right;i++){
            temp[i-left]=arr[i];
        }
        int i=left,j=mid+1;
        for (int k=left;k<=right;k++){
            if (i > mid) {
                arr[k]=temp[j-left];
                j++;
            }else if (j>right){
                arr[k]=temp[i-left];
                i++;
            }else if (temp[i - left].compareTo(temp[j - left]) < 0) {
                arr[k]=temp[i-left];
                i++;
            }else {
                arr[k]=temp[j-left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n=50000;
        Integer[] arr=new SortTestHelper().generateRandomArray(n,0,n);
        //Integer[] arr2=new SelectionSort().copyArray(arr,n);
        //new SelectionSort().testSort("insert",arr2,n);
        //new SelectionSort().testSort("select",arr,n);
        long start=System.nanoTime();
        MergeSort mergeSort=new MergeSort();
        mergeSort.mergeSort(arr,n);
        long end=System.nanoTime();
        System.out.println((end-start)/1000000000.0);
    }

}
