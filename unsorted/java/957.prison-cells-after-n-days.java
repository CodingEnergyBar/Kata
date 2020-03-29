/*
 * @lc app=leetcode id=957 lang=java
 *
 * [957] Prison Cells After N Days
 */

// @lc code=start
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> records = new HashMap<>();
        List<String> list = new ArrayList<>();
        boolean findLoop = false;
        int loop = 0;
        int start = 0;
        while (N > 0) {
            N--;
            cells =  changeAfterOneDay(cells);
            String r = toString(cells);
            if(!records.containsKey(r)){
                int index = list.size();
                list.add(r);
                records.put(r, index);
            }else{
                // find the loop
                int index =  list.size();
                int preIndex = records.get(r);
                findLoop = true;
                loop = index - preIndex;
                start = preIndex;
                break;
            }
        }
        if(findLoop){
            int index = (N - start) % loop + start;
            return stringToArray(list.get(index));
        }
        return cells;
    }
    int[] stringToArray(String r){
        int[] res = new int[r.length()];
        for(int i=0; i< r.length(); i++){
            int p = r.charAt(i) - '0';
            res[i] = p;
        }
        return res;
    }
    String toString(int[] arr){
        StringBuilder res = new StringBuilder();
        for(int i: arr){
            res.append(i);
        }
        return res.toString();
    }
    int[] changeAfterOneDay(int[] cells){
        // 要代替 而不能在原来的数组上修改
        int[] tmp = new int[cells.length];
        for(int i=1; i<cells.length - 1 ;i++){
            tmp[i] = cells[i-1] == cells[i+1]? 1:0;
        }
        return tmp;

    }
}
// @lc code=end

