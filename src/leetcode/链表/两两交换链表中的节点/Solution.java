package leetcode.链表.两两交换链表中的节点;


import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //创建一个虚拟节点用于指向头节点
        ListNode dumpy = new ListNode(0);
        //虚拟节点指向头节点，最终直接返回虚拟节点的下一个节点即可
        dumpy.next = head;
        //pre指向虚拟节点的地址，当pre指针变化时，dumpy.next也会变化，因为两者指向的是同一个地址
        ListNode pre = dumpy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            //第一个节点
            ListNode first = cur;
            //第二个节点
            ListNode second = cur.next;

            //第一个节点连接到第二个节点的下一个节点
            first.next = second.next;
            //第二个节点的下一个节点指针连接到第一个节点，实现节点互换
            second.next = first;

            //前一个节点的下一个节点连接到之前的第二个节点（上面已经换过了，其实是第一个节点）
            pre.next = second;
            //当前节点指针向后移动
            cur = first.next;
            //前一个节点指针向后移动，也就是指向第一个节点
            pre = first;
        }
        //返回虚拟节点的下一个节点，就是头节点
        return dumpy.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode res = new Solution().swapPairs(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


    }
}
