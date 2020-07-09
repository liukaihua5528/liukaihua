package cn.tedu.algorithm.array;

import org.junit.Test;

/**
 * @Date 2020/6/24 0:52
 * @Created by liukaihua
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0;i<arr.length;i++){
            arr[i] = i;
//            System.out.println(arr[i]);
        }
        int[] scores = new int[]{100,99,66};
        for (int score : scores){
            System.out.println(score);
        }
    }

    @Test
    public void toStringTest(){
        Array<Integer> array = new Array<Integer>();
        for (int i= 0 ;i<10;i++){
            array.addLast(i);
        }
        array.addFirst(2);
        System.out.println(array.toString());
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        System.out.println(array.toString());
        array.add(2,10);
        System.out.println(array.toString());
        array.removeFirst();
        System.out.println(array.toString());
        array.remove(2);
        System.out.println(array.toString());
        array.removeElement(4);
        System.out.println(array.toString());
        array.removeLast();
        System.out.println(array.toString());
        System.out.println(array.toString());
    }

    @Test
    public void testEqual(){
//        Array<Integer> array1 = new Array<>(19);
//        Array<Integer> array2 = new Array<>(19);
//        //引用比较
//        System.out.println(array1==array2);
//        //值比较
//        System.out.println(array1.equals(array2));
        Integer a1 = 10;
        Integer a2 = new Integer(10);
        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));
    }

}
