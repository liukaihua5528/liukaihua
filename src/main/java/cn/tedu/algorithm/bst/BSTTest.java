package cn.tedu.algorithm.bst;

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

}
