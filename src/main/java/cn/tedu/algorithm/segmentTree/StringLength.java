package cn.tedu.algorithm.segmentTree;

/**
 * @Date 2020/8/12 21:24
 * @Created by liukaihua
 */
public class StringLength {

    public int getStrLength(String str){
        String[] arr = str.split("\\s+");
        String lastStr = arr[arr.length-1];
        return lastStr.length();
    }

    public static void main(String[] args) {
        StringLength length = new StringLength();
        System.out.println(length.getStrLength("hello wor ld"));
    }

}
