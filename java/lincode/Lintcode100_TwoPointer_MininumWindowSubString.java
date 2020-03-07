import java.util.Arrays;
import java.util.HashMap;

public class Lintcode100_TwoPointer_MininumWindowSubString {


public String minWindow(String src, String target) {
    // write your code here

    // scan src and match target
    int ans = Integer.MAX_VALUE;
    String ansString = "";

    // Initialization
    int[] sHash = new int[256];
    int[] tHash = new int[256];


    initTargetHash(tHash, target);
    initTargetHash(sHash, "");

    int i=0, j=0;
    String searchString = "";

    for(i=0; i<src.length();i++){
        //
        while(j<src.length() && !isValid(sHash,tHash)){
           // Update the hashTable
            sHash[src.charAt(j)]++;
            j++;
        }

        if(isValid(sHash, tHash)){
            // Compare the current min
            if (j-i < ans){
                // is not length
                ans = j-i;
                ansString = src.substring(i,j);
            }
        }

        //declear the number, duplicate char so it is --;
        //前一个和后一个是有关系的
        sHash[src.charAt(i)]--;
    }

    return ansString;
}

int initTargetHash(int[] targetHash, String target){
    //return string length
    int targetNum = 0;
    for (char ch: target.toCharArray()){
        targetHash[ch]++;
        targetNum++;
    }
    return targetNum;

}
boolean isValid(int[] search, int[] target){
    // find the source and target together
    for(int i =0; i< 256;i++){
        if(search[i] < target[i]){
            //the searchString some character did not reach the character number in target string
            // => invalid
            return false;
        }
    }

  return true;
}



    public static void main(String[] args) {
        Lintcode100_TwoPointer_MininumWindowSubString test = new Lintcode100_TwoPointer_MininumWindowSubString();

//        int []nums = new int[]{2, 3,4,6,7,11,15};
        String src= "ADOBECODEBANC";
        String target = "ABC";

        System.out.println("Heli");
        System.out.println(test.minWindow(src, target));

    }
}
