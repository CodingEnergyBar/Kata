import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash =  new HashMap<>();
        for(String str: strs){
            String normalStr =  getNormalized(str);
            if(!hash.containsKey(normalStr)){
                hash.put(normalStr, new ArrayList<String>());
            }
            hash.get(normalStr).add(str);

            // System.out.println("str: " + str + " " + hash.toString());
        }
        // List<> res = new ArrayList<List>();
        // for(String key: hash.keySet()){
        //     res.add(hash.get(key));
        // }
        return new ArrayList<List<String>>(hash.values());

        
    }

    // quick sort template
    String getNormalized(String str){
        char[] arr = str.toCharArray();
        int lo=0, hi=arr.length-1;
        // Arrays.sort(arr);
        quickSort(arr, 0, arr.length-1);

        return new String(arr);
    }
    void quickSort(char[] arr, int start, int end){

        //??
        if(start >= end)
            return;

        int left = start, right= end;
        // pivotIndex 在过程当中也被换掉了, 所以要在重新理解一遍这个含义
        int pivotIndex = left + (right - left) /2;
        char pivot = arr[pivotIndex];
        while(left <= right){
            while(arr[left] < pivot && left <= right) left++;
            while(arr[right] > pivot && left <= right) right--;
            if(left <= right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        quickSort(arr, start, right);
        quickSort(arr, left, end);
        
    }
    void swap(char[] arr, int a, int b){
        char tmp =  arr[a];
        arr[a] = arr[b];
        arr[b] =  tmp;
    }
}
// @lc code=end

