package leetcode.栈.最小栈;

class MinStack2 {
    private Node head;

    static class Node {
        int val;
        int minVal;
        Node next;

        Node(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }

    public MinStack2() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            //将最小值存储在链表节点中，每一个节点存储当前栈顶节点的最小值
            Node newNode = new Node(val, Math.min(val, head.minVal));
            newNode.next = head;
            head = newNode;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minVal;
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-20);
        minStack.push(4);
        minStack.push(-3);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
