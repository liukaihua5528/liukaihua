package cn.tedu.algorithm.segmentTree;

/**
 * @Date 2020/8/11 21:36
 * @Created by liukaihua
 */
public class SegmentTreeTest {

    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1};
        SegmentTree<Integer> tree = new SegmentTree<>(nums,(a, b) -> a+b);
//        System.out.println(tree);
        System.out.println(tree.query(0,2));
    }

}
