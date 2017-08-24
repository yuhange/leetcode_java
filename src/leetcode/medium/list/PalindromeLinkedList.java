package leetcode.medium.list;

/**
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode reversedHead = reverse(head);
        while(head != null && reversedHead != null) {
            if(head.val != reversedHead.val) return false;
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
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
