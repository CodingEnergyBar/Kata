/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] coursesIndegree = new int[numCourses];
        // idnex is the course is courseId
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> curToNext = new HashMap<>();
        for (int[] comb : prerequisites) {
            int cur = comb[1];
            int next = comb[0];
            if (!curToNext.containsKey(cur)) {
                List<Integer> l = new ArrayList<>();
                l.add(next);
                curToNext.put(cur, l);
            } else {
                curToNext.get(cur).add(next);
            }
            coursesIndegree[next]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (coursesIndegree[i] == 0) {
                queue.offer(i);
            }
        }
        System.out.println(queue.toString());
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            if (curToNext.containsKey(cur)) {
                for (int next : curToNext.get(cur)) {
                    coursesIndegree[next]--;
                    if (coursesIndegree[next] == 0)
                        queue.offer(next);
                }
            }
        }
        if (res.size() == numCourses) {
            int[] r = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                r[i] = res.get(i);
            }
            return r;
        } else {
            return new int[0];
        }

    }
}
// @lc code=end

