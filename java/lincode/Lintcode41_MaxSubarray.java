public class Lintcode41_MaxSubarray {


    public int maxSubArray(int[] nums) {
        // write your code here

        int curSum = nums[0];
        for (int i=1 ; i<nums.length; i++){
            if (nums[i] > curSum + nums[i] )
                curSum = nums[i];
            else
                curSum += nums[i];
        }
        return curSum;
    }




    public static void main(String[] args) {
        Lintcode41_MaxSubarray test = new Lintcode41_MaxSubarray();
        int [] nums = new int[] {-2,2,-3,4,-1,2,1,-5,3};
        int result = test.maxSubArray(nums);
        System.out.println(result);
        StringBuffer sb = new StringBuffer("www.insert.com");
        sb.insert (1, "try");
        System.out.println(sb);
    }
}
