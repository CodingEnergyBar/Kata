package lintcode642;

import java.util.Queue;

public class MovingAverage {
    Queue<Integer> queue;
    int capacity;
    long sum;
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.capacity = size;
        this.sum = 0;
        
        // do intialization if necessary
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        if(this.queue.size() == capacity)
        {
            this.sum -= queue.poll();
        }
        this.queue.offer(val);
        this.sum += val;
           return this.sum * 1.0 / queue.size();
        
        // write your code here
    }
}