public class Lintcode100_TwoPointer_TwoSum {


//    public int removeDuplicates(int[] nums) {
//        // write your code here
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//
//        int i=0, j=0;
//        // i = i+1 duplicate  == ignore and replace the
//        for(; i<nums.length-1;i++){
//            if(nums[i] != nums[i+1]){
//                nums[j] = nums[i];
//                j++;
//            }
//        }
//        // deal with the last position
//        nums[j] = nums[i];
//        //index+1 is the length
//        return j+1;
//
//    }
public int[] twoSum(int[] nums, int target) {
    // write your code here
    if (nums == null || nums.length < 2) {
        return new int[0];
    }

    for (int l = 0, r = nums.length - 1; l < r; r--) {
        while (l < r && nums[l] + nums[r] < target) {
            l++;
        }
        if (l != r && nums[l] + nums[r] == target) {
            return new int[]{l + 1, r + 1};
        }

    }
    return new int[0];
}



    public static void main(String[] args) {
        Lintcode100_TwoPointer_TwoSum test = new Lintcode100_TwoPointer_TwoSum();

        int []nums = new int[]{2, 3,4,6,7,11,15};

        System.out.println(test.twoSum(nums, 10));

    }
}
