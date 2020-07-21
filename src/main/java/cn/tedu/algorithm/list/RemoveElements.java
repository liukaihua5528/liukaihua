package cn.tedu.algorithm.list;

/**
 * @Date 2020/7/20 21:03
 * @Created by liukaihua
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head,int val){
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] num = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(num);
        System.out.println(head.toString());
        ListNode result = new RemoveElements().removeElements(head, 6);
        System.out.println(result.toString());
    }

}
