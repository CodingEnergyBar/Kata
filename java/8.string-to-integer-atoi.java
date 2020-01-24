class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        char[] arr = str.toCharArray();

        int i = 0;
        int sign = 1;
        if (arr.length == 0)
            return 0;
        if (arr[0] == '-') {
            sign = -1;
            i++;
        }
        if (arr[0] == '+') {
            i++;
        }

        long res = 0L;

        for (; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                res = res * 10 + Integer.parseInt(String.valueOf(arr[i]));
                if (res > Integer.MAX_VALUE) {
                    if (sign == -1)
                        return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return sign * (int) res;
    }
}