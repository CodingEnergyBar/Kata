import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((x, y)-> y-x);
        
    }
    
    public void addNum(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            }
        }else{
            minHeap.offer(num);
            if(minHeap.size()> maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }

        }
        // System.out.println("maxHeap " + maxHeap.toString());
        // System.out.println("maxHeap peek " + maxHeap.peek());
        // System.out.println("minHeap" + minHeap.toString());
        // System.out.println("minHeap peek " + minHeap.peek());
        
    }
    
    public double findMedian() {
        if(minHeap.size() ==  maxHeap.size())
            return (minHeap.peek()  + maxHeap.peek())/2.0;    
        else{
            return maxHeap.peek() * 1.0;
        } 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

