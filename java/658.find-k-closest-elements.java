/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int t) {
        // find the cloeset to t
        if (arr.length == 0) {
            return null;

        }
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == t) {
                start = mid;
                break;
            } else if (arr[mid] > t) {
                end = mid;
            } else {
                start = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        int i = start, j = start + 1;
        while (res.size() != k && i >= 0 && j <= arr.length - 1) {
            if (Math.abs(t - arr[i]) > Math.abs(arr[j] - t)) {
                res.add(arr[j]);
                j++;
            } else {
                res.add(0, arr[i]);
                i--;
            }
        }
        if (i == -1) {
            while (res.size() != k) {
                res.add(0, arr[i]);
            }
        }
        if (j == arr.length) {
            while (res.size() != k) {
                res.add(arr[j]);
            }
        }
        return res;


    }
}
// @lc code=end

