public class Lintcode457_BinarySearch {


    public int findPosition(int [] nums, int target) {
        // write your code here
        int pos;
        if (nums == null || nums.length == 0){
            return -1;
        }

        int left=0, right = nums.length-1;
        while(left + 1 < right){
            //
            int mid = (right + left)/2 + left;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                left = mid;
            }else if(nums[mid] == target)
                right = mid;
            else
                return -1;

        }
        return left;
    }

    public static void main(String[] args) {
        Lintcode457_BinarySearch test = new Lintcode457_BinarySearch();
        System.out.println((char)('A' + 1));

    }
}
