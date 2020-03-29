import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> mStack;
    Stack<Integer> minStack;

    public MinStack() {
        mStack = new Stack();
        minStack = new Stack();

    }

    public void push(int x) {
        mStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }

    }

    public void pop() {
        int d = mStack.pop();
        if (d == minStack.peek()) {
            minStack.pop();
        }

    }

    public int top() {
        return mStack.peek();

    }

    public int getMin() {
        return minStack.peek();

    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
// @lc code=end
