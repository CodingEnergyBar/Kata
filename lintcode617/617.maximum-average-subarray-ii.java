package lintcode617;

class Solution {
    /**
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            if(num > max) max = num;
            if(num < min) min = num;
        }
        double start = (double) min, end = (double) max; 
        while(end - start > 0.000001){
            double mid = (start + end) * 1.0 / 2;
            if(findOneAbove(nums, k, mid)){
                start = mid;
            }else{
                end = mid;
            }
        }
        return end;
    }
    boolean findOneAbove(int[] nums, int k, double average){
        int L = nums.length;
        double[] arrs = new double[nums.length];
        for(int i=0; i < L; i++){
            arrs[i] = nums[i] - average;
        }
        double sum =0;
        double preSum=0;
        double preSumMin = Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            sum += arrs[i];
        }
        if (sum >= 0)
            return true;
        for(int i=k; i<L; i++){
            sum += arrs[i];
            preSum += arrs[i-k];// windowLeft
            preSumMin = Math.min(preSumMin, preSum);
            if(sum >=0 || sum - preSumMin >= 0)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = new int[]{-1,0,1};
        // int k =3;
        int[] nums = new int[]{5,-10,4};
        int k = 2;
        solution.maxAverage(nums, k);
    }
}