/**
 * Created by lenovo on 2017/3/13.
 */
class ListNode {
    public int val;
    public ListNode next;
    public ListNode (int val) {
        this.val = val;
    }
}
public class ReverseList {
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = null;
        while(cur!=null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        ListNode newHead = reverse(head);
        System.out.print(newHead.val + " " + newHead.next.val);
    }
}
