/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class Cell{
    int val;
    int min;
    Cell(int v, int min){
        this.val = v;
        this.min = min;

    }
}
class MinStack {

    /** initialize your data structure here. */
    List<Cell> data;
    public MinStack() {
         data = new LinkedList<Cell>();
    }
    
    public void push(int x) {
        int min =x;
        if(data.size()!= 0){
            min = Math.min(min, data.get(data.size()-1).min);
        }
        data.add(new Cell(x, min));
        
    }
    
    public void pop() {
        data.remove(data.size()-1);
    }
    
    public int top() {
        return data.get(data.size()-1).val;
        
    }
    
    public int getMin() {
        return  data.get(data.size()-1).min;
        
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

