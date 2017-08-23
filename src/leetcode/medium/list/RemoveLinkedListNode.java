package leetcode.medium.list;

/**
 * Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListNode {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        while(head != null && head.val == val) head = head.next;
        if(head == null) return null;
        ListNode pre = head;
        ListNode cur = head;
        while(cur != null) {
            while(cur != null && cur.val != val) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur == null ? null : cur.next;
            cur = cur == null ? null : cur.next;
        }
        return head;
    }
}
