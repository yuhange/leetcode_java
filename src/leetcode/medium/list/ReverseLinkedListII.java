package leetcode.medium.list;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ? m ? n ? length of list.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        ListNode h = head;
        ListNode pre = head;
        int cnt = 1;
        while(cnt < m) {
            pre = h;
            h = h.next;
            cnt ++;
        }
        ListNode res = reverse(pre, h, m, n);
        if(m == 1) return res;
        return head;
    }

    private ListNode reverse(ListNode preHead, ListNode head, int m, int n) {
        ListNode tmp = head;
        ListNode pre = null;
        ListNode next = null;
        while((n - m + 1) > 0 && head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            n --;
        }
        if(m != 1) preHead.next = pre;
        tmp.next = head;
        return pre;
    }
}
