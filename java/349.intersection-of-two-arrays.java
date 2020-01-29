import java.util.*;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // cannot guava
        // Set<Integer> nums1Set = new HashSet<>(Arrays.asList(new Integer[](nums1)));
        Set<Integer> nums1Set = new HashSet<>();
        for (int i : nums1)
            nums1Set.add(i);

        Set<Integer> res = new HashSet<>();
        for (int i : nums2) {
            if (nums1Set.contains(i))
                res.add(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        Integer[] resArry = { 1, 2, 3 };
        int[] hehe = { 1, 23, 4 };
        Set<Integer> res = new HashSet<>(Arrays.asList(resArry));
        Integer[] res2 = new Integer[res.size()];
        res.toArray(res2);
        System.out.println(Arrays.asList(hehe).getClass().getName()); // );
        // Arrays.toString(list.toArray())
    }
}
// @lc code=end
