package lintcode936;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * @param s: a string
     * @return: a string after capitalizes the first letter
     */
    public String capitalizesFirst(String s) {
        // Write your code here
        String[] a = s.split(" ");
       
        // arr = new ArrayList<String>();
        //  for(String as: a){
        //     if(as.length() != 0)
        //         arr.add(as);
        //  }
        List<String> arr = List.of(a)
                                 .stream()
                                 .filter(e->e.length()!=0)
                                 .collect(Collectors.toList());
        StringBuilder res = new StringBuilder();
        for(int i=0; i<arr.size(); i++){
            res.append(toCaptital(arr.get(i)));
              if(i != arr.size()-1)
                res.append(" ");
        }
        return res.toString();
    }
    String toCaptital(String s){
        char f = s.charAt(0);
        if( !(f <= 'z' && f >='a')) return s;
        
        return (char)(f + 'A' - 'a') + s.substring(1);
    }

    public static void main(String[] args) {
        // int[][] grid = new int[][]

        int[][] grid = new int[][] { { 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
                { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 } };
        String s = "i want to get an accepted";
        System.out.println(new Solution().capitalizesFirst(s));

    }
}