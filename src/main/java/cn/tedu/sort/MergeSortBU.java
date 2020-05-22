package cn.tedu.sort;

/**
 * @Author lkh
 */
public class MergeSortBU {
    private Integer[] arr;
    private int n;
    private MergeSort mergeSort;
    public MergeSortBU(){
        
    }
    public MergeSortBU(Integer[] arr,int n){
        this.arr=arr;
        this.n=n;
    }
    public void mergeSortBU(Integer[] arr,int n){
        for (int sz=1;sz<=n;sz+=sz){
            for (int i=0;i+sz<n;i+=sz+sz){
                mergeSort.merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
            }
        }
    }

}
