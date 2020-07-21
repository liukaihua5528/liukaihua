package cn.tedu.algorithm.list;

/**
 * @Date 2020/7/20 21:04
 * @Created by liukaihua
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 数组作为参数构造函数
     * @param arr
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i=1;i<arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            builder.append(cur.val+"->");
            cur = cur.next;
        }
        builder.append("NULL");
        return builder.toString();
    }
}
