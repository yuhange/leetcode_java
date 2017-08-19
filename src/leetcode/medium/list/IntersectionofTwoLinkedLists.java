package leetcode.medium.list;

/**
 * Created by lenovo on 2017/8/19.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        ListNode hA = headA;
        ListNode hB = headB;
        while(hA != null || hB != null) {
            if(hA != null) {
                hA = hA.next;
                l1 ++;
            }
            if(hB != null) {
                hB = hB.next;
                l2 ++;
            }
        }
        ListNode h = l1 > l2 ? headA : headB;
        int cnt = Math.abs(l1 - l2);
        while(cnt > 0 && h != null) {
            h = h.next;
            cnt --;
        }
        ListNode p = l1 > l2 ? headB : headA;
        while(h != null && p != null) {
            if(h == p) return h;
            h = h.next;
            p = p.next;
        }
        return null;
    }
}
