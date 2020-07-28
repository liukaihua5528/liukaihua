package cn.tedu.algorithm.bst;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Date 2020/7/23 22:54
 * @Created by liukaihua
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num:nums){
            bst.add(num);
        }
//        bst.preOrder();
//        bst.preOrderNR();

        bst.inOrderNR();
    }

    @Test
    public void removeMin(){
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        int n = 1000;
        for (int i = 0;i<n;i++){
            bst.add(random.nextInt(10000));
        }
        System.out.println(bst.size());
        ArrayList<Integer> numbers = new ArrayList<>();
        while (!bst.isEmpty()) {
            numbers.add(bst.removeMin());
        }
        System.out.println(numbers);
        for (int i=1;i<numbers.size();i++){
            if (numbers.get(i - 1) > numbers.get(i)) {
                throw new IllegalArgumentException("error");
            }
        }
    }

}
