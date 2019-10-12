/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (39.00%)
 * Likes:    2172
 * Dislikes: 237
 * Total Accepted:    357.4K
 * Total Submissions: 913.7K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * 
 * 
 * 
 * 
 */

// @lc code=start
class MinStack {

    /** initialize your data structure here. */

    Stack<Integer> stack;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        list = new LinkedList<Integer>();

    }

    public void push(int x) {
        // always keep the min out of the stack
        if(x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(min);

    }

    public void pop() {
        if (min == list.get(list.size() - 1)) {
            min = Integer.MAX_VALUE;
        }
        list.remove(list.size() - 1);

        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, list.get(i));
        }
    }

    public int top() {

        return list.get(list.size() - 1);

    }

    public int getMin() {

        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
// @lc code=end
