public class Lintcode100_TwoPointer_KDistinctSubString {


    public String minLongestKDistinct(String str, int k) {
        // have
        String res = new String();

        // new hash in 256
        int[] hash = new int[256];

        int i, j=0;
        for(i=0;i<str.length();i++){
            while(j<str.length()){
                if (isValid(hash,k)) {

                    if (j - i + 1 > res.length()) {
                        res = str.substring(i, j+1);
                    }
                    // update hash
                    j++;
                    if (j < str.length())
                      hash[str.charAt(j)] += 1;
                }
                else{
                    break;
                }

            }
            hash[str.charAt(i)]-=1;
        }


        return res;
    }

    boolean isValid(int[] str, int k){
        int cnt = 0;
        for(int i=0;i<256;i++){
            if (str[i] > 0){
                cnt++;
            }
        }
        if(cnt <= k)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        Lintcode100_TwoPointer_KDistinctSubString test = new Lintcode100_TwoPointer_KDistinctSubString();

//        int []nums = new int[]{2, 3,4,6,7,11,15};
        String src = "ecebabweourvbslsssdj";
        int k = 3;

        System.out.println(test.minLongestKDistinct(src, k));

    }
}

