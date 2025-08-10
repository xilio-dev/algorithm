package leetcode.链表.环形链表II;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Map<ListNode, ListNode> nodes = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            if (nodes.containsKey(p)) {
                return nodes.get(p);
            } else {
                nodes.put(p, p);
            }
            p = p.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        Solution solution = new Solution();
        ListNode node = solution.detectCycle(head);
        System.out.println(node.val);
    }
}
