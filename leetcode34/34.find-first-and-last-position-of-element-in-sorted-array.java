package leetcode34;
/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         if(nums.length == 0)
//             return new int[]{-1, -1};
//         int firstOccur  = findFirstElement(nums,  target);
//         int lastOccur =  findLastElement( nums,  target);
//         return new int[]{firstOccur, lastOccur};
        
//     }

//     private int findLastElement(int[] nums, int target) {
//         int start = 0, end =nums.length - 1;
//         while(start + 1 <  end){
//             int mid =  start + (end - start) /2;
//             if(nums[mid] > target){
//                 end = mid ;
//             }else{
//                 start = mid ;
//             }
//         }
//         if(nums[end] == target)
//             return end;
//         if(nums[start] == target)
//             return start;
//         return -1;
//     }

//     private int findFirstElement(int[] nums, int target) {
//         int start = 0, end = nums.length - 1;
//         while (start + 1 < end) {
//             int mid = start + (end - start) / 2;
//             if (nums[mid] >= target) {
//                 end = mid;
//             } else {
//                 start = mid;
//             }
//         }
//         if (nums[start] == target)
//             return start;
//         if (nums[end] == target)
//             return end;
//         return -1;
//     }
// }


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };
        int firstOccur = findFirstGreaterEqual(nums, target);
        int lastOccur = findFirstGreaterEqual(nums, target + 1);
        return new int[] { firstOccur, lastOccur };

    }

    private int findFirstGreaterEqual(int[] nums, int target) {
        //[)
        int start = 0, end = nums.length, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                // 如果取到了值,那么 start 会逼近, 只到 start = end
                end = mid;
            }
        }
        return start;
    }

    // private int findLastGreaterEqual(int[] nums, int target) {
    //     // [)
    //     int start = 0, end = nums.length, mid;
    //     while (start < end) {
    //         mid = start + (end - start) / 2;
    //         if (nums[mid] > target) {
    //             end = mid;
    //         } else {
    //             // 如果取到了值,那么 start 会逼近, 只到 start = end
    //             start = mid + 1;
    //         }
    //     }
    //     return start;
    // }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        solution.searchRange(nums, target);
    }
}



// class Solution {
//     public int[] searchRange(int[] A, int target) {
//         int start = Solution.firstGreaterEqual(A, target);
//         if (start == A.length || A[start] != target) {
//             return new int[] { -1, -1 };
//         }
//         return new int[] { start, Solution.firstGreaterEqual(A, target + 1) - 1 };
//     }

//     // find the first number that is greater than or equal to target.
//     // could return A.length if target is greater than A[A.length-1].
//     // actually this is the same as lower_bound in C++ STL.
//     private static int firstGreaterEqual(int[] A, int target) {
//         int low = 0, high = A.length;
//         while (low < high) {
//             int mid = low + ((high - low) >> 1);
//             // low <= mid < high
//             if (A[mid] < target) {
//                 low = mid + 1;
//             } else {
//                 // should not be mid-1 when A[mid]==target.
//                 // could be mid even if A[mid]>target because mid<high.
//                 high = mid;
//             }
//         }
//         return low;
//     }
// }
// @lc code=end

