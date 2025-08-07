package leetcode.链表.返回倒数第k个节点;

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
    public int kthToLast(ListNode head, int k) {
        //快指针先走k步，然后快慢指针一起走，当快指针走到头时，慢指针就是倒数第k个节点
        ListNode fast = head;
        ListNode slow = head;
        //快指针先走k步
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        //快慢指针一起走
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new Solution().kthToLast(head, 2));


    }
}
