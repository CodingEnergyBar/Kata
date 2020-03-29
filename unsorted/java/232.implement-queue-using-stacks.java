import java.util.Stack;

/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
    Stack<Integer> mStack;
    Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        mStack = new Stack();
        popStack = new Stack();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        mStack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (popStack.isEmpty()) {
            while (!mStack.isEmpty()) {
                popStack.push(mStack.pop());
            }
        }
        return popStack.pop();

    }

    /** Get the front element. */
    public int peek() {
        if (popStack.isEmpty()) {
            while (!mStack.isEmpty()) {
                popStack.push(mStack.pop());
            }
        }
        return popStack.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return popStack.isEmpty() && mStack.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
// @lc code=end
