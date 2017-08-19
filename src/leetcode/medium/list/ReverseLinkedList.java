package leetcode.medium.list;

/**
 * Created by lenovo on 2017/8/19.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
