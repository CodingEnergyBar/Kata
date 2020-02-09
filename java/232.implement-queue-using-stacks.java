/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {

    Stack<Integer> mStack;
    Stack<Integer> hStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        mStack = new Stack<Integer>();
        hStack = new Stack<Integer>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        mStack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!mStack.isEmpty()) {
            hStack.push(mStack.pop());
        }
        Integer res = hStack.pop();
        while (!hStack.isEmpty()) {
            mStack.push(hStack.pop());

        }
        return res.intValue();

    }

    /** Get the front element. */
    public int peek() {
        while (!mStack.isEmpty()) {
            hStack.push(mStack.pop());
        }
        Integer res = hStack.peek();
        while (!hStack.isEmpty()) {
            mStack.push(hStack.pop());

        }
        return res.intValue();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mStack.isEmpty();

    }
    // 1 2 push 3 pop push4 push5 pop pop pop
    // queue 123
    // 321
    // 12 3  12
    // 45
    // 12
    // 54
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
// @lc code=end
