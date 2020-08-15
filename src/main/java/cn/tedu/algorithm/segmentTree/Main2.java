package cn.tedu.algorithm.segmentTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Date 2020/8/14 1:02
 * @Created by liukaihua
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        String arrStr = scanner2.nextLine();
        String[] arr = arrStr.split(" ");
        Integer[] arrInt = new Integer[length];
        for (int i=0;i<length;i++){
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        Integer max = Collections.max(Arrays.asList(arrInt));
        Integer secondMax = 0;
        for (int i=0;i<length;i++){
            secondMax = arrInt[i];
            if (secondMax > arrInt[i+1] && secondMax <= max) {
                secondMax = arrInt[i];
            }
        }
        if (max - secondMax == 0) {

        }
    }

}
