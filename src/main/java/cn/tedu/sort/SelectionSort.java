package cn.tedu.sort;


/**
 * @Author lkh
 */
public class SelectionSort<T extends Comparable<T>> {
    private T[] arr;
    private int n;
    public SelectionSort(){
        
    }
    public SelectionSort(T[] arr,int n){
        this.arr=arr;
        this.n=n;
    }
    public T[] selectionSort(){
        for (int i=0;i<arr.length;i++){
            //寻找最小值
            int minIndex=i;
            for (int j=minIndex+1;j<arr.length;j++){
                if (arr[j].compareTo(arr[minIndex])<0){
                    minIndex=j;
                }
            }
            T temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        return arr;
    }
    public void testSort(String sortName,T[] arr,int n){
        long start=System.nanoTime();
        SelectionSort<T> sort=new SelectionSort<>(arr,n);
        sort.selectionSort();
        long end=System.nanoTime();
        System.out.println(sortName);
        System.out.println((end-start)/1000000000.0);
    }

    private static void swap(int i, int j) {
        int temp=i;
        i=j;
        j=temp;
    }
    public Integer[] copyArray(Integer[] a,int n){
        Integer[] arr= new Integer[n];
        for (int i=0;i<a.length;i++){
            arr[i]=a[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        SortTestHelper helper=new SortTestHelper();
        Integer[] a=helper.generateRandomArray(100000,0,100000);
        //Integer[] a={10,9,8,7,6,5,4,3,2,1,11,15,13};
        SelectionSort<Integer> sort=new SelectionSort(a,10);
        Integer[] b=sort.selectionSort();
        for (int i=0;i<b.length-1;i++){
            if (b[i]>b[i+1]){
                System.out.println("大小顺序错误");
            }
            System.out.println(b[i]);
        }
        System.out.println(b.length);
        sort.testSort("b",b,b.length);
        //Double[] c={6.6,3.3,2.2,1.1};
        //SelectionSort<Double> sort1=new SelectionSort<>(c,4);
        //Double[] d=sort1.selectionSort();
        //for (int i=0;i<d.length;i++){
        //    System.out.println(d[i]);
        //}
        //String[] e={"D","C","B","A"};
        //SelectionSort<String> sort2=new SelectionSort<>(e,4);
        //String[] f=sort2.selectionSort();
        //for (int i=0;i<f.length;i++){
        //    System.out.println(f[i]);
        //}
        //Student[] students={new Student("zs",77),new Student("li",55),new Student("ww",33),
        //                new Student("zl",22)};
        //SelectionSort<Student> sort3=new SelectionSort<Student>(students,4);
        //Student[] h=sort3.selectionSort();
        //for (int i=0;i<h.length;i++){
        //    System.out.println(h[i]);
        //}
    }

}
