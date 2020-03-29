import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {

    /** initialize your data structure here. */

    List<Integer> data;

    public MedianFinder() {
        data = new LinkedList<Integer>();
    }

    public void addNum(int num) {
        // 从小到大维护
        int i = 0;
        for (; i < data.size(); i++) {
            if (num < data.get(i)) {
                // 在 i 出插入
                // i = i - 1;
                break;
            }
        }
        // System.out.println("fack");
        data.add(i, num);
    }

    public double findMedian() {
        assert (data.size() > 0);
        // System.out.println(Arrays.toString(data.toArray()));
        int len = data.size();
        if (len % 2 == 1) {

            return data.get(len / 2);
        } else {
            // System.out.println("fac32");
            return (data.get(len / 2) + data.get(len / 2 - 1)) / 2.0;

        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
// @lc code=end
