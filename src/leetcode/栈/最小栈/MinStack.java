package leetcode.栈.最小栈;

import java.util.Stack;

class MinStack {
    /**
     * 该栈用于存储完整的数据
     */
    private final Stack<Integer> stack;
    /**
     * 该栈用于存储最小值，栈顶是最小元素
     */
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        //如果最小栈为空或者当前值小于等于最小栈栈顶元素，将当前值压入最小栈，栈顶元素为最小值
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        Integer value = stack.pop();
        //如果栈顶元素等于最小栈栈顶元素，将最小栈栈顶元素弹出
        if (value.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
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
