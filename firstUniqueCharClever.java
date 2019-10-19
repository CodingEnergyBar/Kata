public class Solution {
    /**
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        // write your code here
        int[] charToCnt = new int[256];
        char[] charArray = s.toCharArray();
        for (char a : charArray) {
            charToCnt[a]++;
        }
        // for(char a: charArray){
        // if(charToCnt[a] == 1){
        // return
        // }
        // }
        for (int i = 0; i < charArray.length; i++) {
            if (charToCnt[charArray[i]] == 1) {
                return i;
            }
        }
        return -1;

    }
}