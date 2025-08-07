package leetcode.链表.反转链表II;



class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head==null||left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev = dummy;
        for (int i = 0; i < left-1; i++) {
            prev=prev.next;
        }
        //例：head = [1,2,3,4,5], left = 2, right = 4
        //prev = 1 cur = 2
        ListNode cur=prev.next;
        for (int i = 0; i < right-left; i++) {
            ListNode next=cur.next;
            cur.next=next.next;
            next.next=prev.next;
            prev.next=next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = new Solution().reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
