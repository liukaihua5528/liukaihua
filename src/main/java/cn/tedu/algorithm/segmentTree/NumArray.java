package cn.tedu.algorithm.segmentTree;

/**
 * @Date 2020/8/14 22:02
 * @Created by liukaihua
 */
public class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i=0;i<nums.length;i++){
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data,(a, b) -> a+b);
        }
    }

    public int sumRange(int i,int j){
        if (segmentTree == null) {
            throw new IllegalArgumentException("segmentTree is null");
        }
        return segmentTree.query(i,j);
    }
}
