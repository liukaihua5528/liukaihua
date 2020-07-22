package cn.tedu.algorithm.list;

/**
 * @Date 2020/7/21 20:54
 * @Created by liukaihua
 */
public class RemoveElements3 {

    public ListNode removeElements3(ListNode head,int val){
        if (head == null) {
            return null;
        }
        ListNode result = removeElements3(head.next, val);
        if (head.val == val) {
            return result;
        }else {
            head.next = result;
            return head;
        }
    }

    private String generateDepthString(int depth) {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<depth;i++){
            builder.append("--");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] num = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(num);
        System.out.println(head.toString());
        ListNode result = new RemoveElements3().removeElements3(head, 6);
        System.out.println(result.toString());
    }

}
