package leetcode.链表.回文链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        StringBuilder s = new StringBuilder();
        while (p!=null){
            s.append(p.val);
            p=p.next;
        }
        String origin = s.toString();
        String reverse = s.reverse().toString();
        return origin.equals(reverse);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        //   head.next.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));

    }
}

