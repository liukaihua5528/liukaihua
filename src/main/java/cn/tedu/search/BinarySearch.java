package cn.tedu.search;

/**
 * 二分查找法,在有序数组arr中，查找target
 * @Author lkh
 */
public class BinarySearch {
    //如果没有找到target 返回-1 找到target返回相应的索引
    public Integer binarySearch(Integer[] arr,int n, Integer target){
        int l=0,r=n-1;
        while (l <= r) {
            //int mid=(l+r)/2;
            int mid=l+(r-l)/2;
            if (arr[mid] == target) {
                return mid;
            }
            //在arr[l...mid-1]
            if (target<arr[mid]){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }

}
