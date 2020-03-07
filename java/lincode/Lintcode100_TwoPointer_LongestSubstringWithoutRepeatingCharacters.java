import java.util.*;

public class Lintcode100_TwoPointer_LongestSubstringWithoutRepeatingCharacters {



    public int lengthOfLongestSubstring(String s) {
        int cnt = Integer.MIN_VALUE;
        int i=0, j=0;

        int[] hash = new int[256];

        for(i=0; i<s.length();i++){
            //charAt
            while(j<s.length() && hash[s.charAt(j)] == 0){
                hash[s.charAt(j)]++;
                //在循环里找到最优解
                cnt = Math.max(j-i+1, cnt);
                j++;
            }
//            if(j-i+1 > cnt){
//                cnt = j-i+1;
//            }
            hash[s.charAt(i)] = 0;
        }

        return cnt;

    }


    public static void main(String[] args) {
        Lintcode100_TwoPointer_LongestSubstringWithoutRepeatingCharacters test = new Lintcode100_TwoPointer_LongestSubstringWithoutRepeatingCharacters();

//        int []nums = new int[]{1, 1, 2,3,3,4};
        String nums = "abawecdea";
        System.out.println(test.lengthOfLongestSubstring(nums));

    }
}

