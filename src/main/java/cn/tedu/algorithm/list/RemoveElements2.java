package cn.tedu.algorithm.list;

/**
 * @Date 2020/7/20 21:38
 * @Created by liukaihua
 */
public class RemoveElements2 {

    public ListNode removeElements2(ListNode head,int val){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] num = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(num);
        System.out.println(head.toString());
        ListNode result = new RemoveElements2().removeElements2(head, 6);
        System.out.println(result.toString());
    }

}
