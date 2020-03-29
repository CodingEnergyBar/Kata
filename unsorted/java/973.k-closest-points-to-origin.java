import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //比较器的写法在复习一下
        if(points == null || points.length < K){
            return points;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((int[] p1, int[] p2)->{
            int x1 = p1[0], y1 = p1[1];
            int x2 = p2[0], y2 = p2[1];
            int d1 =  x1*x1 + y1 * y1;
            int d2 = x2 * x2 + y2* y2;
            return d1 - d2;
        } );
        for(int[] p:points){
            q.offer(p);
        }
        int[][] res = new int[K][];
        for(int i=0; i<K; i++){
            res[i] = q.poll();
        }
        return res;
        
    }
}
// @lc code=end

