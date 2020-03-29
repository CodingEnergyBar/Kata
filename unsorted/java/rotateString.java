public class Solution {
    /**
     * @param str:   An array of char
     * @param left:  a left offset
     * @param right: a right offset
     * @return: return a rotate string
     */
    public String RotateString2(String str, int left, int right) {
        // write your code here
        char[] arr = str.toCharArray();
        // also need to be moded
        int pos = left % str.length() - right % str.length();
        System.out.println("pos " + pos);
        if (pos < 0) {
            // here is +, as it is minus
            pos = str.length() + pos;
        }

        reverse(arr, 0, pos - 1);
        reverse(arr, pos, str.length() - 1);
        reverse(arr, 0, str.length() - 1);

        // return String.join("", arr);
        return new String(arr);
    }

    void reverse(char[] arr, int start, int end) {

        while (start < end) {
            // System.out.println("start " + start + " end " + end);
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}