package cn.tedu.heap;

import java.util.Random;

/**
 * 索引最大堆
 * @Author lkh
 */
public class IndexMaxHeap {
    private Integer[] data;
    private int[] indexes;
    private int count;
    private int capacity;
    private int[] reverse;
    public IndexMaxHeap(int capacity){
        this.capacity=capacity;
        indexes=new int[capacity+1];
        reverse=new int[capacity+1];
        for (int i=0;i<=capacity;i++){
            reverse[i]=0;
        }
        data= new Integer[capacity+1];
        count=0;
    }
    public IndexMaxHeap(Integer[] arr, int n){
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
    //传入的i对用户而言,从0开始
    public void insert(int i,Integer t){
        assert(count+1<=capacity);
        assert(i+1>=1&&i+1<=capacity);
        i+=1;
        data[i]=t;
        indexes[count+1]=i;
        reverse[i]=count+1;
        count++;
        shiftUp(count);
    }
    
    private void shiftUp(int k) {
        while (k>1&&data[indexes[k/2]]<data[indexes[k]]){
            int temp=indexes[k/2];
            indexes[k/2]=indexes[k];
            indexes[k]=temp;
            reverse[indexes[k/2]]=k/2;
            reverse[indexes[k]]=k;
            k/=2;
        }
    }
    public Integer extractMax(){
        assert (count>0);
        Integer ret=data[indexes[1]];
        int temp=indexes[1];
        indexes[1]=indexes[count];
        indexes[count]=temp;
        reverse[indexes[1]]=1;
        reverse[indexes[count]]=0;
        count--;
        shiftDown(1);
        return ret;
    }
    public int extractMaxIndex(){
        assert (count>0);
        int ret=indexes[1]-1;
        int temp=indexes[1];
        indexes[1]=indexes[count];
        indexes[count]=temp;
        count--;
        shiftDown(1);
        return ret;
    }

    /**
     * 根据索引取出元素
     * @param i
     * @return
     */
    public Integer getItem(int i){
        assert (contain(i));
        return data[i+1];
    }
    public void change(int i,Integer newItem){
        assert (contain(i));
        i+=1;
        data[i]=newItem;
        //找到indexes[j]=i j表示data[i]在堆中的位置
        //for (int j=1;j<=count;j++){
        //    if (indexes[j] == i) {
        //        shiftUp(j);
        //        shiftDown(j);
        //        return;
        //    }
        //}
        int j=reverse[i];
        shiftUp(j);
        shiftDown(j);
    }

    private boolean contain(int i) {
        assert (i+1>=1&&i+1<=capacity);
        return reverse[i+1]!=0;
    }

    private void shiftDown(int k) {
        //有左孩子就有右孩子
        while (2 * k <= count) {
            int j=2*k;//在此轮循环中，data[k]和data[j]交换位置
            if (j + 1 <= count&&data[indexes[j+1]]>data[indexes[j]]) {
                j+=1;
            }
            if (data[indexes[k]]>=data[indexes[j]]){
                break;
            }
            int temp=indexes[k];
            indexes[k]=indexes[j];
            indexes[j]=temp;
            reverse[indexes[k]]=k;
            reverse[indexes[j]]=j;
            k=j;
        }
    }

    public static void main(String[] args) {
        IndexMaxHeap maxHeap=new IndexMaxHeap(100);
        System.out.println(maxHeap.getSize());
        Random random=new Random();
        for (int i=0;i<50;i++){
            //maxHeap.insert(random.nextInt(100));
        }
        //for (int i=1;i<maxHeap.getSize()+1;i++){
        //    System.out.println(maxHeap.data[i]);
        //}
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.extractMax());
        }
    }

}
