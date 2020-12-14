import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSelect {



        /**
         * @param head: the given linked list
         * @return: the array that store the values in reverse order
         */
       int partition(int [] nums, int start, int end){
           int left = start, right = end;
           int pivot = nums[(left + right) / 2];
           while(left <= right){
               while(left <= right && nums[left] < pivot)left++;
               while(left <= right && nums[right] > pivot ) right--;
               if(left <= right) {
                   swap(nums, left, right);
                   left++;
                   right--;
               }

           }
           return left;
       }
       void swap(int[] nums, int i, int j){
           int tmp = nums[i];
           nums[i] = nums[j];
           nums[j] = tmp;
       }




    public static void main(String[] args) {
        QuickSelect test = new QuickSelect();


        int []nums = new int[]{5,3,4,7,6};
        test.partition(nums, 0, nums.length-1);


    }
}
