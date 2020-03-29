import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        int step = 1;

        String cur = beginWord;

        Queue<String> q = new LinkedList<>();
        q.add(cur);
        visited.add(cur);

        while (!q.isEmpty()) {

            int size = q.size();
            // 先加上
            step++;

            // boolean canNextStep = false;
            for (int i = 0; i < size; i++) {
                // !!!亲爱的这里啊,
                cur = q.poll();

                for (String word : wordList) {
                    if (!visited.contains((word)) && canTransfer(cur, word)) {
                        // 出口在这里
                        if (word.equals(endWord)) {
                            return step;
                        }
                        // canNextStep = true;
                        q.offer(word);
                        visited.add(word);
                    }
                }
            }

        }
        return 0;

    }

    boolean canTransfer(String begin, String end) {
        int diff = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != end.charAt(i))
                diff++;
        }
        return diff <= 1;
    }
}
// @lc code=end
