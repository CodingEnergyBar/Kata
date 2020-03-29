public class Lintcode14_FirstPosOfTarget {


    public int binarySearch(int[] nums, int target) {
        // write your code here
        // find a index
        int left = 0;
        int right = nums.length - 1;

        int biIndex=0;
        while (left + 1 < right){
            int mid = left + (right - left)/2;
            if (target > nums[mid]){
                left = mid;
            }else if (target < nums[mid] ){
                right = mid;
            }else{
                biIndex = mid;
                while (biIndex-1 >= 0 && nums[biIndex-1] == nums[biIndex]){
                    biIndex--;
                }
                    return biIndex;

            }
        }

        if (nums[left] == target){
            while (biIndex-1 >= 0 && nums[biIndex-1] == nums[biIndex]){
                biIndex--;
            }
            return biIndex;
        }else if(nums[right] == target){
            while (biIndex-1 >= 0 && nums[biIndex-1] == nums[biIndex]){
                biIndex--;
            }
            return biIndex;
        }
        else
            return -1;
    }



    public static void main(String[] args) {
        Lintcode14_FirstPosOfTarget test = new Lintcode14_FirstPosOfTarget();

        int []nums = new int[]{1,4,4,5,7,7,8,9,9,10};

        System.out.println(test.binarySearch(nums, 4));

    }
}
