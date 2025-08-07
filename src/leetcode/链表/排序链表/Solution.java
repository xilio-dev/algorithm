package leetcode.链表.排序链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        //用一个集合存储节点的值
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        Collections.sort(list);
        ListNode q = head;
        for (Integer value : list) {
            q.val = value;
            q = q.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode result = new Solution().sortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
