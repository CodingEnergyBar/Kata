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

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        // 0<= min - max <= 1
        // [[maxHeap] [minHeap]]

        minHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<>();

    }

    public void addNum(int num) {
        if (minHeap.isEmpty()) {
            minHeap.add(num);
        } else {
            if (minHeap.size() - maxHeap.size() == 1) {
                // balance 放到 maxheap => max < min
                // if (minHeap.peek() > num) {
                // maxHeap.add(minHeap.poll());
                // minHeap.add(num);
                // } else {
                // maxHeap.add(num);
                // }
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                // 放到 minheap 中 后面的
                // num

                // if (maxHeap.peek() < num) {
                // minHeap.add(maxHeap.poll());
                // maxHeap.add(num);
                // } else {
                // minHeap.add(num);
                // }
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
            // throw new Error("soemthign wrong");

        }

    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
// @lc code=end
