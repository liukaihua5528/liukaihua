package cn.tedu.algorithm.segmentTree;

import java.util.Scanner;

/**
 * @Date 2020/8/14 0:52
 * @Created by liukaihua
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n < 3 || n > 7) {
            System.out.println(-1);
            return;
        }
        int numL = (int) Math.pow(10,n-1);
        int numR = (int) Math.pow(10,n);
        int count = -1;
        for (int num=numL;n<numR;num++){
            int sd = num%10;
            int hd = num/100;
            int td=(num-100*hd)/10;
            if (num == hd * hd * hd + td * td * td + sd * sd * sd) {
                count++;
                if (count == m) {
                    System.out.println(num+"是第"+(count+1)+"水仙花数");
                    break;
                }
            }
        }
    }

}
