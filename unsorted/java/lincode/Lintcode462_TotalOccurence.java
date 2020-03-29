public class Lintcode462_TotalOccurence {


    public int totalOccurrence(int[] A, int target) {
        // write your code here
        // find the first occurrence

        if(A==null || A.length == 0) return 0;

        int left = 0, right =A.length-1;

        while(left + 1 < right){
            int mid = left + (right-left)/2;
            if(A[mid] == target){
                right = mid;
            }else if(A[mid] > target){
                right = mid;
            }else
                left = mid;
        }

        int start;
        if(A[left] == target )
            start = left;
        else if(A[right] == target)
            start = right;
        else
            return 0;


        left = 0;
        right = A.length-1;
        while(left + 1 < right){
            int mid = left + (right-left)/2;
            if(A[mid] == target){
                left = mid;
            }else if(A[mid] > target){
                right = mid;
            }else
                left = mid;
        }

        int end;
        if(A[right] == target)
            end = right;
        else if(A[left] == target)
            end = left;
        else
            return 0;

        return end - start;
    }




    public static void main(String[] args) {
        Lintcode462_TotalOccurence test = new Lintcode462_TotalOccurence();
        int [] A = new int[] {1,3,3,4,5};
        System.out.println(test.totalOccurrence(A,3));

    }
}
