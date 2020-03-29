public class Lintcode662_GuessNum {


    public int guessNumber(int n, int target) {
        // Write your code here

        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == mid){
                return mid;
            }else if(target > mid){
                end = mid;
            }else {
                start = mid;
            }
        }
        if (start == target)
            return start;
        else if(end == target)
            return end;
        else
            return -1;
    }




    public static void main(String[] args) {
        Lintcode662_GuessNum test = new Lintcode662_GuessNum();
        System.out.println(test.guessNumber(10,4));

    }
}
