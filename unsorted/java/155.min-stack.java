/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> data;
    Stack<Integer> curMin;
 
    public MinStack() {
        data = new Stack<>();
        curMin = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
        if(curMin.isEmpty() || curMin.peek() >= x){
            curMin.push(x);
        }
        
    }
    
    public void pop() {
        if(data.isEmpty())
            return;
        int cur = data.peek();
        if(curMin.peek() == cur){
            curMin.pop();
        }
        data.pop();
        
    }
    
    public int top() {
        return data.peek();
        
    }
    
    public int getMin() {
        return curMin.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

