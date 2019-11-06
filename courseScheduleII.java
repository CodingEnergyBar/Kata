public class Solution {
    /*
     * @param numCourses: a total of n courses
     * 
     * @param prerequisites: a list of prerequisite pairs
     * 
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        List<Integer>[] edges = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int[] info : prerequisites) {
            int course = info[0];
            int pre = info[1];
            // graphy is still the right direction
            edges[pre].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList();
        List<Integer> order = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                order.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = (int) queue.poll();

            for (int next : edges[cur]) {
                // indgree is always drop, so cannot be in the queue twice
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                    order.add(next);
                }
            }
        }
        if (order.size() != numCourses)
            return new int[0];
        else
            // list.stream().mapToInt(i->i).toArray();
            return order.stream().mapToInt(i -> i).toArray();

    }
}