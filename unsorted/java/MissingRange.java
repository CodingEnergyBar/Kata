public class Solution {
    /*
     * @param nums: a sorted integer array
     * 
     * @param lower: An integer
     * 
     * @param upper: An integer
     * 
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> res = new ArrayList<>();
        for(int num: nums){
            if(num == lower){
                lower++;
            }
            else if(num > lower){
                if(lower + 1 == num){
                    res.add(lower+"");
                }else{
                    res.add(lower + "->" + (num-1));
                }
                if(num < 2147483647)
                    lower = num+1;
                else{
                    return res;n
                }
            }
        }
        if(lower == upper){
            
                res.add(upper + "");
            
        }else if(lower < upper){
            res.add(lower + "->" + upper);
        }
        return res;

    }
}