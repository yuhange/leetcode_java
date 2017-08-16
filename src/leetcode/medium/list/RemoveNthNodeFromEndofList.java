package leetcode.medium.list;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.


 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 滑动窗口
        if(head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = head;
        int cnt = 0;
        // 定位倒数第n个节点
        while(p2 != null && cnt < n) {
            p2 = p2.next;
            cnt ++;
        }
        while(p1 != null && p2 != null) {
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        // p1是倒数第n个节点。pre是其前一个节点 注意p1为头结点的情况 return head.next;
        if(p1 == head) return head.next;
        else pre.next = p1.next;
        return head;
    }
}
