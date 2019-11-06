/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (39.18%)
 * Likes:    2181
 * Dislikes: 102
 * Total Accepted:    257.2K
 * Total Submissions: 655.1K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */

// @lc code=start
class Solution {
    /*
     * @param numCourses: a total of n courses
     * 
     * @param prerequisites: a list of prerequisite pairs
     * 
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        // Build the graph
        // Map<Integer, Set<Integer>> courseToPres = new HashMap();

        // i -> pres
        List<Integer>[] graph = new ArrayList[numCourses];
        // course -> Pre Number
        int[] degree = new int[numCourses];

        // Intilization
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
            // map.get(i).push
        }

        // map graph
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph[pre].add(course);
            degree[course]++;
        }

        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                visited.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = (int) queue.poll();

            for (Integer next : graph[cur]) {
                degree[next]--;
                // indegree is 0 to the queue
                if (degree[next] == 0 && !visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return visited.size() == numCourses;
    }
}

// @lc code=end
