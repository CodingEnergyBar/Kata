public class Lintcode100_TwoPointer_RemoveDuplicate {


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
//    public int removeDuplicates(int[] A) {
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        int size = 0;
//        // include
//        // older place restore the lastest non-duplicate position
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] != A[size]) {
//                A[++size] = A[i];
//            }
//        }
//        return size + 1;
//    }


    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }

        int i=0, j=1;

//        for (i=0; i<A.length; i++){
//            while(A[j] == A[i]){
//                j++;
//            }
//            A[i] = A[j];
//        }
//        for(i=0; i< A.length; i++){
//            while(j<A.length){
//                if(A[j] == A[i]){
//                    j++;
//                }else{
//                    if( i != 0)
//                       A[i] = A[j];
//                    break;
//                }
//            }
//        }
        for (j=1; j<A.length;j++){

        }
        for(int z=0; z<i;z++){
            System.out.print(A[z]);
        }
        return i+1;

    }




    public static void main(String[] args) {
        Lintcode100_TwoPointer_RemoveDuplicate test = new Lintcode100_TwoPointer_RemoveDuplicate();

        int []nums = new int[]{1, 1, 2,3,3,4};

        System.out.println(test.removeDuplicates(nums));

    }
}
