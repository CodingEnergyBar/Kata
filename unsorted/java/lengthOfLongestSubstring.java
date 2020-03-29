public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int i = 0, j = 0, maxLen = 0;
        HashSet<Character> strSet = new HashSet();
        for (; j < s.length(); j++) {
            if (!strSet.contains(s.charAt(j))) {

                maxLen = Math.max(j - i + 1, maxLen);

                strSet.add(s.charAt(j));
                System.out.println("substring: " + s.substring(i, j + 1));
                System.out.println(strSet.toString());
            } else {
                System.out.println("j " + j);
                while (i < s.length() && s.charAt(i) != s.charAt(j)) {

                    strSet.remove(s.charAt(i));
                    i++;
                    System.out.println("substring 2: " + s.substring(i, j + 1));
                    System.out.println(strSet.toString());
                }
                // Here as the find the last one is the same and not remove from hashset
                // strSet.remove(s.charAt(i));
                i++;
                System.out.println("substring 3: " + s.substring(i, j + 1));
                System.out.println(strSet.toString());

            }
        }
        return maxLen;
    }

}