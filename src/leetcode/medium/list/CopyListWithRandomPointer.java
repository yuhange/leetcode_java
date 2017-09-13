package leetcode.medium.list;

import java.util.HashMap;

/**
 * Created by lenovo on 2017/8/23.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copy(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();// map存放旧节点->新节点的映射
        RandomListNode nHead = new RandomListNode(head.value); // 复制链表的头
        map.put(head, nHead);
        RandomListNode pre = nHead;
        RandomListNode next = head.next;

        // 构建复制链表的主体结构，不包括random节点
        while(next != null) {
            RandomListNode nNext = new RandomListNode(next.value); // 每一个节点都复制一份
            map.put(next, nNext);
            pre.next = nNext;
            pre = nNext;
            next = next.next;
        }

        // 构建random节点
        RandomListNode copy = nHead;
        next = head;
        while(next != null) {
            copy.random = map.get(next.random); // 获得旧节点的random，得到的实际上是新链表里的一个节点
            copy = copy.next;
            next = next.next;
        }
        return nHead;
    }

    public RandomListNode copyMethod2(RandomListNode head) {
        if(head == null) return null;
        // HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();// map存放旧节点->新节点的映射
        RandomListNode node = head;

        // 构建重复节点的链表
        while(node != null) {
            RandomListNode nNode = new RandomListNode(node.value); // 每一个节点都复制一份，接在原节点的后面
            nNode.next = node.next;
            node.next = nNode;
            node = node.next;
        }

        // 构建random节点
        node = head;
        while(node != null) {
            if(node.random != null) {
                node.next.random = node.random.next;
            } else {
                node.next.random = null;
            }
            node = node.next.next;
        }

        // 拆分链表成为新链表和旧链表
        node = head;
        RandomListNode nHead = node.next;
        while(node != null) {
            RandomListNode nNode = node.next;
            node.next = nNode.next;
            if(nNode.next != null) {
                nNode.next = nNode.next.next;
            }
            node = node.next;
        }
        return nHead;
    }
}

class RandomListNode {
    int value;
    RandomListNode next, random;
    RandomListNode(int x) { this.value = x; }
};
