public class Solution {
    /**
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        // write your code here
        Map<Character, Integer> charToIndex = new HashMap();
        Map<Character, Integer> charToCnt = new HashMap();

        char[] sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            char a = s.charAt(i);

            // contain key
            if (!charToCnt.containsKey(a)) {
                charToCnt.put(a, 0);
                charToIndex.put(a, i);
            }

            charToCnt.put(a, charToCnt.get(a) + 1);

        }
        int index = Integer.MAX_VALUE;
        for (Character a : charToCnt.keySet()) {
            if (charToCnt.get(a) == 1 && charToIndex.get(a) < index) {
                index = charToIndex.get(a);
            }
        }
        if (index == Integer.MAX_VALUE)
            return -1;
        return index;
    }
}