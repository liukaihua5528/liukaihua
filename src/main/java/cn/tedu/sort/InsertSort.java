package cn.tedu.sort;

/**
 * @Author lkh
 */
public class InsertSort<T extends Comparable<T>> {
    private T[] arr;
    private int n;
    public InsertSort(){
        
    }
    public InsertSort(T[] arr,int n){
       this.arr=arr;
       this.n=n;
    }
    public T[] insertionSort(T[] arr,int n){
        for (int i=1;i<n;i++){
            //寻找元素arr[i]合适的插入位置
            T e=arr[i];
            int j;
            for (j=i;j>0;j--){
                if (arr[j - 1].compareTo(e)>0) {
                    //T temp=arr[j];
                    //arr[j]=arr[j-1];
                    //arr[j-1]=temp;
                    arr[j]=arr[j-1];
                }else {
                    break;
                }
            }
            arr[j]=e;
        }
        return arr;
    }

    public static void main(String[] args) {
        int n=10000;
        Integer[] arr=new SortTestHelper().generateRandomArray(n,0,n);
        Integer[] arr2=new SelectionSort().copyArray(arr,n);
        new SelectionSort().testSort("insert",arr2,n);
        new SelectionSort().testSort("select",arr,n);
    }

}
