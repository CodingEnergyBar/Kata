/**
 * @param n: An integer
 * @param nums: An array
 * @return: the Kth largest element
 */
const kthLargestElement = function (n, nums) {
    // write your code here
    let start = 0, end = nums.length - 1;
    
    
    let result = partition(nums, start, end, n-1);
    
    return result;
 
    
    function partition(nums, left, right, k){
        
        let pivot = nums[(left+right)/2];
    
        while(left <= right){
            while(left <= right && nums[left] > pivot){
                left++;
            }
            while(left <= right && nums[right] < pivot){
                right--;
            }
            if(left <= right){
                swap(nums, left, right);
                left++;
                right--;
            }
            
             if(k <= right){
                partition(nums, start, right, k);
            }
           
            
             if(k >= left){
                partition(nums, left, end, k);
            }
            
            
            return nums[k];
        }
    }
    
    
    function swap(nums, a, b){
        let tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}