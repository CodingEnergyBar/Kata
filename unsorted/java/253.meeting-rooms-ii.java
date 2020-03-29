/*
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 * 
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]] Output: 2 Example 2:
 * 
 * Input: [[7,10],[2,4]] Output: 1 NOTE: input types have been changed on April 15, 2019. Please
 * reset to default code definition to get new method signature.
 * 
 * 
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;

        for (int i = 0; i < intervals.length; i++) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.offer(end);

            if (pq.size() > max)
                max = pq.size();
        }
        return max;

    }
}
