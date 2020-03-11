import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        for (String log : logs) {
            if (isDigitLog(log)) {
                digitLogs.add(log);

            } else {
                letterLogs.add(log);
            }

            // s.matches("-?\\d+")
        }

        letterLogs.sort((s1, s2) -> {

            String s1c = s1.substring(s1.indexOf(" ") + 1);
            String s2c = s2.substring(s2.indexOf(" ") + 1);
            if (s1c.compareTo(s2c) != 0) {
                return s1c.compareTo(s2c);
            } else {
                String c1 = s1.substring(0, s1.indexOf(" "));
                String c2 = s2.substring(0, s2.indexOf(" "));
                return c1.compareTo(c2);
            }
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);

    }

    boolean isDigitLog(String log) {
        String[] arr = log.split(" ");
        if (arr[1].matches("-?\\d+")) {
            return true;
        }
        return false;
    }
}
// @lc code=end
