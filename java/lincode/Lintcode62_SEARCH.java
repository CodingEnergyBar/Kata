public class Lintcode62_SEARCH {


    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0)
            return -1;
        int left = 0, right = A.length - 1;

        while (left + 1 < right){
            int mid = left + (right - left) / 2;

            if (A[mid] > target){
                if (target < A[0])
                    left = mid;
                else
                    right = mid;
            }else if (A[mid] == target){

                return mid;

            }else{
                if(target > A[A.length-1])
                    right = mid;
                else
                    left = mid;
            }
        }
        if(A[left] == target)
            return left;
        if(A[right] == target)
            return right;
        return -1;
    }



    public static void main(String[] args) {
        Lintcode62_SEARCH test = new Lintcode62_SEARCH();

        int []nums = new int[]{1, 2,3};

        System.out.println(test.search(nums, 1));

    }
}
